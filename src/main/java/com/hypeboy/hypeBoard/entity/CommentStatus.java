package com.hypeboy.hypeBoard.entity;

import lombok.Data;

import java.util.Arrays;
import java.util.Optional;

@Data
public class CommentStatus {
    private Status id = Status.ACTIVE;

    public CommentStatus(String status) throws Exception {
        this.id = Status.toStatus(status);
    }

    public String getId() {
        return id.value;
    }

    private enum Status {
        ACTIVE("active"),
        REPORTED("reported"),
        BLOCKED("blocked"),
        DELETED("deleted");

        private String value;

        Status(String statusString) {
            this.value = statusString;
        }

        public static Status toStatus(String text) throws Exception {
            Optional<Status> status = Arrays.stream(Status.values())
                    .filter((s) -> text.equals(s.value))
                    .findAny();

            return status.orElseThrow(() -> new Exception("CommentStatus:>> No matched Status"));
        }
    }
}
