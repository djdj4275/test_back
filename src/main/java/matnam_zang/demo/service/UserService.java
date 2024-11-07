package matnam_zang.demo.service;

import matnam_zang.demo.entity.User;
import matnam_zang.demo.repository.UserRepository;
import matnam_zang.demo.security.TokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    // User 생성
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // User ID로 조회
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // 특정 username을 가진 User 조회
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // 특정 email을 가진 User 조회
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // 회원가입
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.USER);  // 기본 ROLE_USER 설정
        userRepository.save(user);
    }

    // 로그인
    public String loginUser(String username, String password) {
        // Optional<User>로 user 조회
        Optional<User> optionalUser = userRepository.findByUsername(username);
        
        // User가 존재하는지 확인
        if (optionalUser.isPresent()) {
            User user = optionalUser.get(); // 값 추출
            
            // 비밀번호가 일치하는지 확인
            if (passwordEncoder.matches(password, user.getPassword())) {
                // 로그인 성공 시 JWT 토큰 생성
                return tokenProvider.createToken(user.getUsername());
            }
        }
        
        // username이나 비밀번호가 잘못된 경우 예외 발생
        throw new RuntimeException("Invalid username or password");
    }
}
