package com.example.login.registration;

import com.example.login.appuser.AppUser;
import com.example.login.appuser.AppUserRole;
import com.example.login.appuser.AppUserService;
import com.example.login.registration.token.ConfirmationToken;
import com.example.login.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail){
            throw new IllegalStateException("Email is not valid.");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER)
                );
    }
}
