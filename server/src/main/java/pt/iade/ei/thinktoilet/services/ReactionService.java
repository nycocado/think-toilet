package pt.iade.ei.thinktoilet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iade.ei.thinktoilet.exceptions.DatabaseSaveException;
import pt.iade.ei.thinktoilet.exceptions.NotFoundException;
import pt.iade.ei.thinktoilet.models.entities.Comment;
import pt.iade.ei.thinktoilet.models.entities.Reaction;
import pt.iade.ei.thinktoilet.models.entities.TypeReaction;
import pt.iade.ei.thinktoilet.models.entities.User;
import pt.iade.ei.thinktoilet.models.requests.ReactionRequest;
import pt.iade.ei.thinktoilet.models.response.ApiResponse;
import pt.iade.ei.thinktoilet.repositories.ReactionRepository;
import pt.iade.ei.thinktoilet.repositories.TypeReactionRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;
    @Autowired
    private TypeReactionRepository typeReactionRepository;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    public Reaction getReactionByCommentIdAndUserId(int commentId, int userId) {
        return reactionRepository.findReactionByCommentIdAndUserId(commentId, userId);
    }

    public TypeReaction getTypeReactionByName(String type) {
        return Optional.ofNullable(typeReactionRepository.findTypeReactionByName(type))
                .orElseThrow(() -> new NotFoundException(type, "TypeReaction", "name"));
    }

    public Reaction saveReaction(Reaction reaction) {
        return Optional.of(reactionRepository.save(reaction))
                .orElseThrow(() -> new DatabaseSaveException("Reaction"));
    }

    @Transactional
    public ResponseEntity<ApiResponse> addReaction(ReactionRequest request) {
        Comment comment = commentService.getCommentById(request.getCommentId());
        User user = userService.getUserById(request.getUserId());
        TypeReaction typeReaction = getTypeReactionByName(request.getTypeReaction());

        Reaction reaction = Optional.ofNullable(getReactionByCommentIdAndUserId(comment.getId(), user.getId()))
                .orElseGet(() -> {
                    Reaction newReaction = new Reaction();
                    newReaction.setComment(comment);
                    newReaction.setUser(user);
                    return newReaction;
                });

        reaction.setTypeReaction(typeReaction);
        reaction.setCreationDate(LocalDate.now());

        saveReaction(reaction);

        ApiResponse response = new ApiResponse(HttpStatus.CREATED.value(), "Reaction added successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}