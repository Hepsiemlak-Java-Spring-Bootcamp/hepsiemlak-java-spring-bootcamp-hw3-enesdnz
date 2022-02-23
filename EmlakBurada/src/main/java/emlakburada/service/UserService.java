package emlakburada.service;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.queue.QueueService;
import emlakburada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import emlakburada.repository.DbConnectionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	@Qualifier(value = "mongoConnectionRepository")
	private DbConnectionRepository dbConn;

	@Autowired
	private UserRepository userRepository;

	private static int advertNo = 12345678;

	@Autowired
	private QueueService queueService;

	public List<UserResponse> getAllUsers() {

		List<UserResponse> userList = new ArrayList<>();
		for (User user : userRepository.fetchAllUser()) {
			userList.add(convertToUserResponse(user));
		}
		return userList;
	}

	public UserResponse saveUser(UserRequest request) {
		User savedUser = userRepository.saveUser(convertToUser(request));
		EmailMessage emailMessage = new EmailMessage("enodeniz@gmail.com");
		queueService.sendMessage(emailMessage);
		return convertToUserResponse(savedUser);
	}

	private UserResponse convertToUserResponse(User savedUser) {
		UserResponse response = new UserResponse();
		response.setIsim(savedUser.getIsim());
		response.setUserId(savedUser.getUserId());
		response.setEmail(savedUser.getEmail());
		response.setBiyografi(savedUser.getBiyografi());
		response.setFotograf(savedUser.getFotograf());
		response.setKullaniciTipi(savedUser.getKullaniciTipi());
		return response;
	}

	private User convertToUser(UserRequest request) {
		User user = new User();
		advertNo += 10;

		user.setUserId(advertNo);
		user.setIsim(request.getIsim());
		user.setEmail(request.getEmail());
		user.setBiyografi(request.getBiyografi());
		user.setFotograf(request.getFotograf());
		user.setKullaniciTipi(request.getKullaniciTipi());
		return user;
	}

	public UserResponse getUserByUserId(int userId) {
		User user = userRepository.findUserByUserId(userId);
		return convertToUserResponse(user);
	}

	public AdvertResponse getFavoriteAdvertByUserId(int userId) {
		AdvertResponse advert = userRepository.prepareFavoriteAdvert(userId);
		return advert;
	}

}
