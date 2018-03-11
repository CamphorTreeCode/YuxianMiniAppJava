/**
 * default_1501644919208
 * API接入，支持Java、C#、Php、Python等开发语言接入，可下发全球231+国家与地区手机。快速实现互联网企业跨国业务的开展。
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package test.java.api;

import wxlink.ApiException;

import org.junit.Test;

import api.DefaultApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    
    /**
     * 国际短信、国际短信验证码、国际短信接口、国际短信通知
     *
     * 国际短信、国际短信验证码、国际短信接口、国际短信通知
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void intSmsTest() throws ApiException {
        String mobile = null;
        String appkey = null;
        // String response = api.intSms(mobile, appkey);

        // TODO: test validations
    }
    
    public static void main(String[] args) {
    	 
        DefaultApi apiInstance = new DefaultApi();
        
        String mobile = "13665600140"; // String | 接收短信的手机号码，多个号码以半角逗号,隔开
        
        String appkey = "ba5e37abf9c7d011649a121201fa66bd"; // String | 万象平台提供的appkey
        
        try {
            String result = apiInstance.intSms(mobile,appkey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#int_sms");
            e.printStackTrace();
        }
    }
    
}