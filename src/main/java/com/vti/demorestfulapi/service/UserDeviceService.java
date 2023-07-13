package com.vti.demorestfulapi.service;

import com.vti.demorestfulapi.dto.DeviceInfo;
import com.vti.demorestfulapi.exception.TokenRefreshException;
import com.vti.demorestfulapi.model.RefreshToken;
import com.vti.demorestfulapi.model.UserDevice;
import com.vti.demorestfulapi.repository.UserDeviceRepository;
import com.vti.demorestfulapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeviceService {

    @Autowired
    private UserDeviceRepository userDeviceRepository;

    @Autowired
    UserRepository userRepository;

    public Optional<UserDevice> findByUserId(Long userId) {
        return userDeviceRepository.findByUserId(userId);
    }

    public Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken) {
        return userDeviceRepository.findByRefreshToken(refreshToken);
    }

    public UserDevice createUserDevice(DeviceInfo deviceInfo) {
        UserDevice userDevice = new UserDevice();
        userDevice.setDeviceId(deviceInfo.getDeviceId());
        userDevice.setDeviceType(deviceInfo.getDeviceType());
        userDevice.setIsRefreshActive(true);
        return userDevice;
    }

    public void verifyRefreshAvailability(RefreshToken refreshToken) {
        UserDevice userDevice = findByRefreshToken(refreshToken)
                .orElseThrow(() -> new TokenRefreshException(refreshToken.getToken(), "No device found for the matching token. Please login again"));

        if (!userDevice.getIsRefreshActive()) {
            throw new TokenRefreshException(refreshToken.getToken(), "Refresh blocked for the device. Please login through a different device");
        }
    }

    public void deleteAll()
    {
        userDeviceRepository.deleteAll();
    }

    public void deleteOldDevice(Long userId)
    {
//        Optional<User> optionalUser = userRepository.findById(userId);
//        userDeviceRepository.dele
    }
}
