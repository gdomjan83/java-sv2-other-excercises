package potvizsga7.message;

public class MessageService {
    private MessageRepository messageRepository;
    private UserRepository userRepository;

    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void registerUser(String username) {
        if (usernameExists(username)) {
            throw new IllegalArgumentException("Username is already taken: " + username);
        }
        userRepository.insertUser(username);
    }

    public void sendMessage(User sender, User receiver, String message) {
        if (usernameExists(sender.getUsername()) && usernameExists(receiver.getUsername())) {
            long senderId = userRepository.findUserByName(sender.getUsername()).get().getId();
            String receiverId = String.valueOf(userRepository.findUserByName(receiver.getUsername()).get().getId());
            messageRepository.insertMessage(senderId, receiverId, message);
        }
    }

    private boolean usernameExists(String username) {
        return userRepository.findUserByName(username).isPresent();
    }
}
