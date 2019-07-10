package Default;

import common.util;
import net.sf.json.JSONObject;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class depositApi {
    //    String baseURL = "http://134.175.161.212:8086/deposit/";
    String baseURL = "http://3.130.122.199:8086/deposit/";


    @Test(enabled = false)
    public void depositAccountEnquiryGet_accountNumber() {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        String accountNumber = "undefined";

        String url = baseURL + "deposit/account/accountDetails/" + accountNumber;

        try {
            URIBuilder uriBuilder = new URIBuilder(url);
//            uriBuilder.setParameters(params);

//            String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
//            HttpGet get = new HttpGet(url+"?"+str);
            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("content-type", "application/json;charset=UTF-8");

            get.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
            get.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
            get.setHeader("clientid", "devin");

            CloseableHttpResponse response = httpclient.execute(get);
            String res = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositAccountEnquiryPost() {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        JSONObject paramASE = new JSONObject();
        paramASE.put("accountnumber", "HK720001001000000001001");

        JSONObject params = new JSONObject();
        params.put("ase", paramASE);

        HttpPost post = new HttpPost(baseURL + "deposit/account/accountNumberValidation");

        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");
        post.setEntity(new StringEntity(paramASE.toString(), "UTF-8"));

        try {
            CloseableHttpResponse response = httpclient.execute(post);
            String res = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositAccountEnquiryGet_customerNumber() {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        String customerNumber = "001000000001";
        String url = baseURL + "deposit/account/allAccounts/" + customerNumber;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
//            uriBuilder.setParameters(params);
            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("content-type", "application/json;charset=UTF-8");
            get.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
            get.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
            get.setHeader("clientid", "devin");

            CloseableHttpResponse response = httpclient.execute(get);
            String res = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositAccountMaintenanceGet() {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        String accountNumber = "HK720001001000000001001";
        String url = baseURL + "deposit/account/accountClosure/" + accountNumber;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
//            uriBuilder.setParameters(params);
            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("content-type", "application/json;charset=UTF-8");
            get.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
            get.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
            get.setHeader("clientid", "devin");

            CloseableHttpResponse response = httpclient.execute(get);
            String res = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 202);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositAccountOpeningPost() {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        JSONObject accountModel = new JSONObject();
        accountModel.put("accountType", "001");
        accountModel.put("currencyCode", "HKD");
        accountModel.put("customerNumber", "001000000001");
        accountModel.put("relaccountnumber", "HK720001001000000001001");

        HttpPost post = new HttpPost(baseURL + "deposit/account/accountCreation");

        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");
        try {
            post.setEntity(new StringEntity(accountModel.toString(), "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(post);
            String res = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 202);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositCurrentAccountOpeningPost() {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        String result = null;

        HttpPost post = new HttpPost(baseURL + "deposit/account/currentAccountOpening");

        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");
        try {
            post.setEntity(new StringEntity(util.getStringValue("/deposit/currentAccountOpening.txt"), "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(post);
            String res = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositFeAccountOpeningPost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseURL + "deposit/account/feAccountOpening");
        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");
        try {
            post.setEntity(new StringEntity(util.getStringValue("/deposit/feAccountOpening.txt"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(post);
            String reps = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositMetAccountOpeningPost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseURL + "deposit/account/metAccountOpening");
        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");
        try {
            post.setEntity(new StringEntity(util.getStringValue("/deposit/metAccountOpening.txt"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(post);
            String res = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 500);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositSavingAccountOpeningPost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseURL + "deposit/account/savingAccountOpening");
        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");
        try {
            post.setEntity(new StringEntity(util.getStringValue("/deposit/savingAccountOpening.txt"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(post);
            String str = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositTdAccountOpeningPost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseURL + "deposit/account/savingAccountOpening");
        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");
        try {
            post.setEntity(new StringEntity(util.getStringValue("/deposit/tdAccountOpening.txt"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(post);
            String str = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositCusMainCustContactInfoUpdatePost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseURL + "deposit/account/custContactInfoUpdate");
        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");

        try {
            post.setEntity(new StringEntity(util.getStringValue("/deposit/custContactInfoUpdate.txt"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(post);
            String str = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositCusMainCustomerCreationPost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseURL + "deposit/account/customerCreation");
        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");

        try {
            post.setEntity(new StringEntity(util.getStringValue("/deposit/customerCreation.txt"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(post);
            String str = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositTermDepositCusMainCustomerCreationGet() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String accountNumber = "HK760001001000000005100";
        HttpGet get = new HttpGet(baseURL + "deposit/term/getTermDepositByAccount/" + accountNumber);
        get.setHeader("content-type", "application/json");
        get.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        get.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        get.setHeader("clientid", "devin");

        try {
            CloseableHttpResponse response = httpClient.execute(get);
            String str = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositTermDepositAllEnquiryCustomerNumberGet() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String customerNumber = "001000000001";
        HttpGet get = new HttpGet(baseURL + "deposit/term/termDepositAllEnquiry/" + customerNumber);
        get.setHeader("content-type", "application/json");
        get.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        get.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        get.setHeader("clientid", "devin");

        try {
            CloseableHttpResponse response = httpClient.execute(get);
            String str = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void depositTermDepositTermDepositApplicationPost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseURL + "deposit/term/termDepositApplication");
        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");

        try {
            post.setEntity(new StringEntity(util.getStringValue("deposit/termDepositApplication.txt"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(post);
            String str = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true)
    public void depositTermDepositTermDepositDrawDownPost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseURL + "deposit/term/termDepositDrawDown");
        post.setHeader("content-type", "application/json");
        post.setHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8y00OwiAQhuG7zNoFkBLUpbqwadI7ADNWEn4aWozGeHchNs7yme99A9KDfJop9xc4gkTaG6XtTQrRCWEPhMKojhnDLVdKwg5sKnHNr3NCqsF1aORJZxenzRhjvKrJOtr73xr5NLk46tBkdqGlZVlToDyWYCj_hmy7Viw64ik9e6wv-HwBAAD__w.alc0ibAbJotnPxSQL2wtt9Qo8h0YYzl4WkxOK65PnGy1fK4SDmNRRVEohqOya_K7qOXJOt5Cjdm10cejK3PViA");
        post.setHeader("messageid", "006f7113e5fa48559549c4dfe74e2cd6");
        post.setHeader("clientid", "devin");

        try {
            post.setEntity(new StringEntity(util.getStringValue("deposit/termDepositDrawDown.txt"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(post);
            String str = EntityUtils.toString(response.getEntity());
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
