package com.example.restexample.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class WsdlActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wsdl);

        (new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                GetExpiration("173.194.35.33");
                return null;
            }
        }).execute();
    }


    static String NAMESPACE = "http://www.webservicex.net/";
    static String URL = "http://www.webservicex.net/geoipservice.asmx";

    public static String GetExpiration(String ip) {
        String METHOD_NAME = "GetGeoIP";
        String SOAP_ACTION = NAMESPACE + METHOD_NAME;

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("IPAddress", ip);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.setAddAdornments(false);

        envelope.setOutputSoapObject(request);
        HttpTransportSE ht = new HttpTransportSE(URL);

        String ret = null;
        try {
            ht.debug = true;
            ht.call(SOAP_ACTION, envelope);

            SoapObject a = (SoapObject) envelope.bodyIn;

            if (a.getPropertyCount() > 0) {
                ret = a.getPropertyAsString(0);
            }

        } catch (Exception e) {

        }
        return ret;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wsdl, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
