package com.saif.familytree.core;


import com.saif.familytree.R;
import com.saif.familytree.core.constants.ErrorCodes;
import com.saif.familytree.utils.StringUtil;

/**
 * Created by ganna on 8/26/16.
 */
public class FamilyTreeException extends Throwable {

    private int errorCode;

    public FamilyTreeException(int errorCode) {
        super(getExceptionInternalMessage(errorCode));
        this.errorCode = errorCode;
    }



    public int getErrorCode() {
        return errorCode;
    }

    public static String getExceptionInternalMessage(int errorCode) {
        String msg = null;
        switch (errorCode) {
            case ErrorCodes.NO_INTERNET_CONNECTION:
                msg = StringUtil.getStringRes(R.string.check_internet_connection_title);
                break;
            case ErrorCodes.UNKNOWN_ERROR:
                msg = StringUtil.getStringRes(R.string.error_general);
                break;
            case ErrorCodes.USER_NAME_EXIST_CODE:
                msg = StringUtil.getStringRes(R.string.user_name_in_use);
                break;
            case ErrorCodes.EMAIL_EXIST_CODE:
                break;
            case ErrorCodes.EMAIL_NOT_EXIST_CODE:
                break;
            case ErrorCodes.INCORRECT_EMAIL_OR_PASS_CODE:
                break;
            case ErrorCodes.INCORRECT_USER_NAME_CHARS:
                break;
            case ErrorCodes.EMTPTY_FEED:
                break;
            default:
                msg = "No message specified for this exception";
                break;
        }
        return msg;
    }


}
