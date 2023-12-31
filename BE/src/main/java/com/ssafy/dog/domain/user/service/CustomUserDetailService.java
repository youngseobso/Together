package com.ssafy.dog.domain.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssafy.dog.common.error.UserErrorCode;
import com.ssafy.dog.common.exception.ApiException;
import com.ssafy.dog.domain.user.entity.User;
import com.ssafy.dog.domain.user.model.UserRole;
import com.ssafy.dog.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userLoginId) throws UsernameNotFoundException {
		Optional<User> user = this.userRepository.findByUserLoginId(userLoginId);
		if (user.isEmpty()) {
			throw new ApiException(UserErrorCode.USER_NOT_FOUND);
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		if ("kihong2424@gmail.com".equals(userLoginId)) {
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}
		return new org.springframework.security.core.userdetails.User(
			user.get().getUserLoginId(),
			user.get().getUserPw(),
			authorities
		);
	}
}
