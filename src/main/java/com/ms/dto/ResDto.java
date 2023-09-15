package com.ms.dto;

import java.util.Optional;

public class ResDto<T> {
    private boolean hasError = false;
    private Optional<T> data = Optional.ofNullable(null);
    private Optional<String> errorMsg = Optional.ofNullable(null);


    public ResDto() {};

    public void setData(T data) {
        this.data = Optional.of(data);
    }

    public void setErrorMsg(String msg) {
        this.hasError = true;
        this.errorMsg = Optional.of(msg);
    }

    @Override
    public String toString() {

        return data.isPresent() ? data.get().toString() : errorMsg.get();
    }
}
