package com.ferhatkaplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.UserDataHandler;

import java.net.PasswordAuthentication;

@Service("userService")
public class DefaultUserService   {

    @Autowired
    private UserRepository userRepository;

    @Autowired
   public class passwordEncoder; {

    @Override
    public void register(UserData user) throws UserAlreadyExistException {

        //Let's check if user already registered with us
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }


    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) !=null ? true : false;
    }
    private void encodePassword( UserEntity userEntity, UserData user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }


}
}