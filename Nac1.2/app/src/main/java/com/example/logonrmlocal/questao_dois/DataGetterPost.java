package com.example.logonrmlocal.questao_dois;

import android.os.AsyncTask;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class DataGetterPost extends AsyncTask<String,Void,String>
{
    private TextView txtPost;

    public DataGetterPost(TextView txtFeedback)
    {
        this.txtPost = txtFeedback;
    }

    @Override
    protected String doInBackground(String... strings)
    {
        return NetworkToolkit.doPost(strings[0],strings[1]);
    }

    @Override
    protected void onPostExecute(String string) {
        try
        {
            JSONObject jsonResponse = new JSONObject(string);
            String id = jsonResponse.getString("id");
            txtPost.setText("O ID é: " + id);
        }
        catch(JSONException e)
        {
            this.txtPost.setText(e.toString());
        }
    }
}