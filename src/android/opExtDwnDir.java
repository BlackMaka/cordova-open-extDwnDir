package com.open.opExtDwnDir;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

/**
 * This class echoes a string called from JavaScript.
 */
public class opExtDwnDir extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("opExtDwnDir")) {
//            String message = args.getString(0);
//            this.coolMethod(message, callbackContext);
//
//            return true;

            int READ_REQUEST_CODE = 42;


            // 파일을 가져오기 위해 ACTION_OPEN_DOCUMENT을 사용한다.
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            // 이후 파일중 open가능한 것들로 카테고리를 묶기 위해 CATEGORY_OPENABLE을 사용한다.
            intent.addCategory(Intent.CATEGORY_OPENABLE);

            // 이제 Storage Access Framework에서 제공하는 UI에 노출될 MIME을 지정한다. 여기서는 이미지를 기준으로 작업하므로 image/라고 표기했지만
            // 오디오를 가지고 오고 싶다면 audio/를 사용하며 오디오 파일형식 중에서도 ogg파일만을 보고 싶다면 audio/ogg라고 명시한다. 만약 모든 파일을 보고 싶다면 */*로 표기하면 된다.
            //intent.setType(“image/*”);
            intent.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

            // 결과를 onActivityResult()로 전달받기 위해 startActivityForResult로 실행한다.
            //startActivityForResult(intent, READ_REQUEST_CODE);
            if (this.cordova != null) {
                this.cordova.startActivityForResult((CordovaPlugin) this,
                        intent, READ_REQUEST_CODE);
            }
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
