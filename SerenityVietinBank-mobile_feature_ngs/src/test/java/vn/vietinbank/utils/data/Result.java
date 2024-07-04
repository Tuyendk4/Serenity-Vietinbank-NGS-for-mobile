package vn.vietinbank.utils.data;

import lombok.Getter;

@Getter
public class Result {

    private final boolean passed;

    public Result(boolean passed) {
        this.passed = passed;
    }

}
