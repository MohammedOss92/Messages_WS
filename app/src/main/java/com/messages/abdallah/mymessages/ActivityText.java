package com.messages.abdallah.mymessages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityText extends AppCompatActivity {
    EditText ed;
    ImageView img;
    ////////////////
    ImageView copy1;
    ImageView copy2;
    ImageView copy3;
    ImageView copy4;
    ImageView copy5;
    ImageView copy6;
    ImageView copy7;
    ImageView copy8;
    ImageView copy9;
    EditText input;
    int index;
    EditText out1;
    EditText out2;
    EditText out3;
    EditText out4;
    EditText out5;
    EditText out6;
    EditText out7;
    EditText out8;
    EditText out9;
    ImageView press;
    ImageView share1;
    ImageView share2;
    ImageView share3;
    ImageView share4;
    ImageView share5;
    ImageView share6;
    ImageView share7;
    ImageView share8;
    ImageView share9;
    /////////////////
    Button b1;

    public static void hideSoftKeyboard(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity_text);
//        this.interstitial = new InterstitialAd(this);
//        this.interstitial.setAdUnitId("ca-app-pub-5653393892523683/5617942210");
//        AdView adView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new Builder().build();
//        adView.loadAd(adRequest);
//        this.interstitial.loadAd(adRequest);
//        this.interstitial.setAdListener(new AdListener() {
//            public void onAdClosed() {
//            }
//        });
//        ed= (EditText) findViewById(R.id.editText2);
//        Intent i=getIntent();
//        ed.setText(i.getExtras().getString("name"));
//        img = (ImageView) findViewById(R.id.imageView);
//        b1     = (Button) findViewById(R.id.button);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                selectImage();
//            }
//        });

        this.input = (EditText) findViewById(R.id.intext);
        this.out1 = (EditText) findViewById(R.id.out1);
        this.out2 = (EditText) findViewById(R.id.out2);
        this.out3 = (EditText) findViewById(R.id.out3);
        this.out4 = (EditText) findViewById(R.id.out4);
        this.out5 = (EditText) findViewById(R.id.out5);
        this.out6 = (EditText) findViewById(R.id.out6);
        this.out7 = (EditText) findViewById(R.id.out7);
        this.out8 = (EditText) findViewById(R.id.out8);
        this.out9 = (EditText) findViewById(R.id.out9);
        this.press = (ImageView) findViewById(R.id.press);
        this.copy1 = (ImageView) findViewById(R.id.copy1);
        this.copy2 = (ImageView) findViewById(R.id.copy2);
        this.copy3 = (ImageView) findViewById(R.id.copy3);
        this.copy4 = (ImageView) findViewById(R.id.copy4);
        this.copy5 = (ImageView) findViewById(R.id.copy5);
        this.copy6 = (ImageView) findViewById(R.id.copy6);
        this.copy7 = (ImageView) findViewById(R.id.copy7);
        this.copy8 = (ImageView) findViewById(R.id.copy8);
        this.copy9 = (ImageView) findViewById(R.id.copy9);
        this.share1 = (ImageView) findViewById(R.id.share1);
        this.share2 = (ImageView) findViewById(R.id.share2);
        this.share3 = (ImageView) findViewById(R.id.share3);
        this.share4 = (ImageView) findViewById(R.id.share4);
        this.share5 = (ImageView) findViewById(R.id.share5);
        this.share6 = (ImageView) findViewById(R.id.share6);
        this.share7 = (ImageView) findViewById(R.id.share7);
        this.share8 = (ImageView) findViewById(R.id.share8);
        this.share9 = (ImageView) findViewById(R.id.share9);


        Intent ii=getIntent();
        input.setText(ii.getExtras().getString("na"));

//        else if(index==1)
//        {
//            Intent ii=getIntent();
//            input.setText(ii.getExtras().getString("namee"));
//        }

        img = (ImageView) findViewById(R.id.imageView1);
        this.press.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int j;
                ActivityText.hideSoftKeyboard(ActivityText.this);
                String o0 = ActivityText.this.input.getText().toString();
                String o3 = ActivityText.this.input.getText().toString();
                String o4 = ActivityText.this.input.getText().toString();
                String o5 = ActivityText.this.input.getText().toString();
                String o6 = ActivityText.this.input.getText().toString();
                String o7 = ActivityText.this.input.getText().toString();
                String o8 = ActivityText.this.input.getText().toString();
                String o9 = ActivityText.this.input.getText().toString();
                String org = ActivityText.this.input.getText().toString();
                char[] r19 = new char[31];
                r19 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a'};
                String[] str2 = new String[]{"\u0622", "\u0622", "\u0622", "\u0622", "\u0628\u0651\u0640", "\u062a\u064f", "\u062b\u064b\u0640", "\u062c\u064e \u0640", "\u062d\u064b \u0640", "\u062e\u064c \u0640", "\u062f\u064f", "\u0630\u064c", "\u0631\u064e", "\u0632\u064e", "\u0633\u064b\u0640", "\u0634\u0651\u0640", "\u0635\u0650\u0640", "\u0636\u0640", "\u0637\u064c\u0640", "\u0638\u064c\u0640", "\u0639\u064e \u0640", "\u063a\u0651 \u0640", "\u0641\u064f", "\u0642\u064e", "\u0643\u064e", "\u0644\u064e", "\u0645\u0650\u0640", "\u0646\u064c", "\u0647\u0650", "\u0648\u064f", "\u064a\u0651"};
                char[] r20 = new char[31];
                r20 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a'};
                String[] str22 = new String[]{"\u0622", "\u0622", "\u0622", "\u0622", "\u0628\u0651\u06d2\u0640", "\u062a\u064f\u06d2\u0640", "\u062b\u064b\u06d2\u0640", "\u062c\u064e\u06d2\u0640", "\u062d\u064b\u06d2\u0640", "\u062e\u064c\u06d2\u0640", "\u062f\u064f", "\u0630\u064c", "\u0631\u064e", "\u0632\u064e", "\u0633\u064b\u06d2\u0640", "\u0634\u0651\u06d2\u0640", "\u0635\u0650\u06d2\u0640", "\u0636\u06d2\u0640", "\u0637\u064c\u06d2\u0640", "\u0638\u064c\u06d2\u0640", "\u0639\u064e\u06d2\u0640", "\u063a\u0651\u06d2\u0640", "\u0641\u064f\u06d2\u0640", "\u0642\u064e\u06d2\u0640", "\u0643\u06d2\u0640", "\u0644\u064e", "\u0645\u0650\u06d2\u0640", "\u0646\u064c\u06d2\u0640", "\u0647\u06d2\u0640\u0650", "\u0648\u064f", "\u064a\u0651\u06d2\u0640"};
                char[] r21 = new char[32];
                r21 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a', '\u0629'};
                String[] str23 = new String[]{"\u0622", "\u0623\u0650", "\u064f\u0625", "\u0622", "\u0628\u06c1", "\u062a\u06c1", "\u062b\u06c1", "\u062c\u06c1", "\u062d\u06c1", "\u062e\u06c1", "\u062f", "\u0630", "\u0631", "\u0632", "\u0633\u06c1", "\u0634\u06c1", "\u0635\u06c1", "\u0636\u06c1", "\u0637\u06c1", "\u0638\u06c1", "\u0639\u06c1", "\u063a\u06c1", "\u0641\u06c1", "\u0642\u06c1", "\u0643\u06c1", "\u0644", "\u0645\u06c1", "\u0646\u06c1", "\u0647\u06c1", "\u0624", "\u064a\u06c1", "\u0647\u06c1"};
                char[] r22 = new char[32];
                r22 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a', '\u0629'};
                String[] str24 = new String[]{"\u0622", "\u064d\u0622", "\u0622\u064c", "\u0622\u064f", "\u0628\u0651", "\u062a\u064f", "\u062b\u064b", "\u062c\u064e", "\u062d", "\u062e\u064c", "\u062f\u064f", "\u0630\u064c", "\u0631", "\u0632", "\u0633\u064b\u0640", "\u0634\u0651\u0640", "\u0635\u0650\u0640", "\u0636\u0640", "\u0637\u064c\u0640", "\u0638\u064c\u0640", "\u0639\u064e", "\u063a\u0651", "\u0641\u064f", "\u0642\u064e", "\u06af", "\u0644\u064e", "\u0645\u0650\u0640", "\u0646", "\u0647\u0650\u06c1\u200f\u200f", "\u0648\u064f", "\u064a\u0640\ufbaf", "\u200f\u200f\u0647\u0650\u06c1\u064f\u200f\u200f\u064f\u064f"};
                char[] r23 = new char[31];
                r23 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a'};
                String[] str25 = new String[]{"\ufb51", "\ufb51", "\ufb51", "\ufb51", "\u0628", "\u067c", "\u062b", "\ufb75", "\u062d", "\u062e", "\u068a", "\u068e", "\u0631", "\u0697", "\u0633", "\u069c", "\u0635", "\u0636", "\u0637", "\u069f", "\u0639", "\u06a0", "\u0641", "\u06a6", "\u06af", "\u0644", "\u0645", "\u06b9", "\u06ff", "\u0648", "\u064a"};
                char[] r24 = new char[31];
                r24 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a'};
                String[] str26 = new String[]{"\u0622", "\u0622", "\u0622", "\u0622", "\u0628\ufba7", "\u062a\ufba7", "\u062b\ufba7", "\u062c\ufba7", "\u062d\ufba7", "\u062e\ufba7", "\u062f", "\u0630", "\u0631", "\u0632", "\u0633\ufba7", "\u0634\ufba7", "\u0635\ufba7", "\u0636\ufba7", "\u0637\ufba7", "\u0638\ufba7", "\u0639\ufba7", "\u063a\ufba7", "\u0641\ufba7", "\u0642\ufba7", "\u0643\ufba7", "\u0644\ufba7", "\u0645\ufba7", "\u0646\ufba7", "\u0647\ufba7", "\u0648", "\u064a\ufba7"};
                char[] r25 = new char[31];
                r25 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a'};
                String[] str27 = new String[]{"\u0622", "\u0622", "\u0622", "\u0622", "\u0628\u0640\u0640", "\u062a", "\u062b\u0640", "\u062c \u0640", "\u062d \u0640", "\u062e \u0640", "\u062f", "\u0630", "\u0631", "\u0632", "\u0633\u0640", "\u0634\u0640", "\u0635\u0640", "\u0636\u0640", "\u0637\u0640", "\u0638\u0640", "\u0639 \u0640", "\u063a \u0640", "\u0641", "\u0642", "\u0643", "\u0644", "\u0645\u0640", "\u0646", "\u0647", "\u0648", "\u064a"};
                char[] r26 = new char[31];
                r26 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a'};
                String[] str28 = new String[]{"\u0622", "\u0622", "\u0622", "\u0622", "\u0628\u06d2\u0640", "\u062a\u06d2\u0640", "\u062b\u06d2\u0640", "\u062c\u06d2\u0640", "\u062d\u06d2\u0640", "\u062e\u06d2\u0640", "\u062f", "\u0630", "\u0631", "\u0632", "\u0633\u06d2\u0640", "\u0634\u06d2\u0640", "\u0635\u06d2\u0640", "\u0636\u06d2\u0640", "\u0637\u06d2\u0640", "\u0638\u06d2\u0640", "\u0639\u06d2\u0640", "\u063a\u06d2\u0640", "\u0641\u06d2\u0640", "\u0642\u06d2\u0640", "\u0643\u06d2\u0640", "\u0644", "\u0645\u06d2\u0640", "\u0646\u06d2\u0640", "\u0647\u06d2\u0640\u0650", "\u0648", "\u064a\u06d2\u0640"};
                char[] r27 = new char[32];
                r27 = new char[]{'\u0627', '\u0623', '\u0625', '\u0622', '\u0628', '\u062a', '\u062b', '\u062c', '\u062d', '\u062e', '\u062f', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063a', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u064a', '\u0629'};

                String[] str29 = new String[]{"\u0622", "\u0622", "\u0622", "\u0622", "\u0628", "\u062a", "\u062b", "\u062c", "\u062d", "\u062e", "\u062f", "\u0630", "\u0631", "\u0632", "\u0633\u0640", "\u0634\u0640", "\u0635\u0640", "\u0636\u0640", "\u0637\u0640", "\u0638\u0640", "\u0639", "\u063a", "\u0641", "\u0642", "\u06af", "\u0644", "\u0645\u0640", "\u0646", "\u0647\u06c1\u200f\u200f", "\u0648", "\u064a\u0640\ufbaf", "\u200f\u200f\u0647\u06c1"};
                for (int i = 0; i < org.length(); i++) {
                    for (j = 0; j < r19.length; j++) {
                        if (org.charAt(i) == r19[j]) {
                            org = org.replaceAll(new StringBuilder(String.valueOf(org.charAt(i))).toString(), new StringBuilder(String.valueOf(str2[j])).toString());
                            r19[j] = '\u0000';
                            str2[j] = "";
                        }
                    }
                    for (j = 0; j < r20.length; j++) {
                        if (o0.charAt(i) == r20[j]) {
                            o0 = o0.replaceAll(new StringBuilder(String.valueOf(o0.charAt(i))).toString(), new StringBuilder(String.valueOf(str22[j])).toString());
                            r20[j] = '\u0000';
                            str22[j] = "";
                        }
                    }
                }
                for (int k = 0; k < o3.length(); k++) {
                    for (j = 0; j < r21.length; j++) {
                        if (o3.charAt(k) == r21[j]) {
                            o3 = o3.replaceAll(new StringBuilder(String.valueOf(o3.charAt(k))).toString(), new StringBuilder(String.valueOf(str23[j])).toString());
                            r21[j] = '\u0000';
                            str23[j] = "";
                        }
                    }
                }
                for (int m = 0; m < o4.length(); m++) {
                    for (j = 0; j < r22.length; j++) {
                        if (o4.charAt(m) == r22[j]) {
                            o4 = o4.replaceAll(new StringBuilder(String.valueOf(o4.charAt(m))).toString(), new StringBuilder(String.valueOf(str24[j])).toString());
                            r22[j] = '\u0000';
                            str24[j] = "";
                        }
                    }
                }
                for (int s = 0; s < o5.length(); s++) {
                    for (j = 0; j < r23.length; j++) {
                        if (o5.charAt(s) == r23[j]) {
                            o5 = o5.replaceAll(new StringBuilder(String.valueOf(o5.charAt(s))).toString(), new StringBuilder(String.valueOf(str25[j])).toString());
                            r23[j] = '\u0000';
                            str25[j] = "";
                        }
                    }
                }
                for (int n = 0; n < o6.length(); n++) {
                    for (j = 0; j < r24.length; j++) {
                        if (o6.charAt(n) == r24[j]) {
                            o6 = o6.replaceAll(new StringBuilder(String.valueOf(o6.charAt(n))).toString(), new StringBuilder(String.valueOf(str26[j])).toString());
                            r24[j] = '\u0000';
                            str26[j] = "";
                        }
                    }
                }
                for (int b = 0; b < o7.length(); b++) {
                    for (j = 0; j < r25.length; j++) {
                        if (o7.charAt(b) == r25[j]) {
                            o7 = o7.replaceAll(new StringBuilder(String.valueOf(o7.charAt(b))).toString(), new StringBuilder(String.valueOf(str27[j])).toString());
                            r25[j] = '\u0000';
                            str27[j] = "";
                        }
                    }
                }
                for (int x = 0; x < o8.length(); x++) {
                    for (j = 0; j < r26.length; j++) {
                        if (o8.charAt(x) == r26[j]) {
                            o8 = o8.replaceAll(new StringBuilder(String.valueOf(o8.charAt(x))).toString(), new StringBuilder(String.valueOf(str28[j])).toString());
                            r26[j] = '\u0000';
                            str28[j] = "";
                        }
                    }
                }
                for (int u = 0; u < o9.length(); u++) {
                    for (j = 0; j < r27.length; j++) {
                        if (o9.charAt(u) == r27[j]) {
                            o9 = o9.replaceAll(new StringBuilder(String.valueOf(o9.charAt(u))).toString(), new StringBuilder(String.valueOf(str29[j])).toString());
                            r27[j] = '\u0000';
                            str29[j] = "";
                        }
                    }
                }
                ActivityText.this.out1.setText(org);
                ActivityText.this.out2.setText(o0);
                ActivityText.this.out3.setText(o3);
                ActivityText.this.out4.setText(o4);
                ActivityText.this.out5.setText(o5);
                ActivityText.this.out6.setText(o6);
                ActivityText.this.out7.setText(o7);
                ActivityText.this.out8.setText(o8);
                ActivityText.this.out9.setText(o9);
            }
        });
        this.copy1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out1.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out1.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
        this.copy2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out2.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out2.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
        this.copy3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out3.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out3.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
        this.copy4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out4.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out4.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
        this.copy5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out5.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out5.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
        this.copy6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out6.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out6.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
        this.copy7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out7.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out7.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
        this.copy8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out8.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out8.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
        this.copy9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ClipboardManager) ActivityText.this.getSystemService("clipboard")).setText(ActivityText.this.out9.getText().toString());
                Toast.makeText(ActivityText.this.getBaseContext(), "\u062a\u0645 \u0646\u0633\u062e \u0645\u062d\u062a\u0648\u0649 \u0645\u0631\u0628\u0639 \u0627\u0644\u0646\u0635 \u0627\u0644\u0646\u0627\u062a\u062c", 1).show();
            }
        });
        this.share9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.TEXT", ActivityText.this.out9.getText().toString());
                ActivityText.this.startActivity(Intent.createChooser(sharingIntent, "\u0634\u0627\u0631\u0643 \u0628\u0648\u0627\u0633\u0637\u0629 :"));
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
    }



    ///////////////////////////////////////////////////////////////////






//    private void selectImage() {
//        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityText.this);
//        builder.setTitle("Add Photo!");
//        builder.setItems(options, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int item) {
//                if (options[item].equals("Take Photo"))
//                {
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
//                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
//                    startActivityForResult(intent, 1);
//                }
//                else if (options[item].equals("Choose from Gallery"))
//                {
////                    Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
////                    intent.setType("image/*");
////                    startActivityForResult(Intent.createChooser(intent, "Select File"),2);
//
//                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(intent, 2);
////
////                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
////                    photoPickerIntent.setType("image/*");
////                    startActivityForResult(photoPickerIntent, 2);
//
//                } else if (options[item].equals("Cancel")) {
//                    dialog.dismiss();
//                }
//            }
//        });
//        builder.show();
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            if (requestCode == 1) {
//                File f = new File(Environment.getExternalStorageDirectory().toString());
//                for (File temp : f.listFiles()) {
//                    if (temp.getName().equals("temp.jpg")) {
//                        f = temp;
//                        break;
//                    }
//                }
//                try {
//                    Bitmap bitmap;
//                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//
//                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
//                            bitmapOptions);
//
//                    // bitmap = Bitmap.createScaledBitmap(bitmap, 70, 70, true);
//                    img.setImageBitmap(bitmap);
//
//                    String path = android.os.Environment
//                            .getExternalStorageDirectory()
//                            + File.separator
//                            + "Phoenix" + File.separator + "default";
//                    f.delete();
//                    OutputStream outFile = null;
//                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
//                    try {
//                        outFile = new FileOutputStream(file);
//                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
//                        outFile.flush();
//                        outFile.close();
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } else if (requestCode == 2) {
////                Uri selectedImageUri = data.getData();
////                String p=selectedImageUri.getPath();
////
////                String tempPath = data.getDataString();
////                Log.i("path of image from gallery......******************.........", p);
////                Bitmap bitmap;
////                BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
////                bitmap = BitmapFactory.decodeFile(tempPath, bitmapOptions);
////                viewImage.setImageBitmap(bitmap);
//
//                Uri selectedImage = data.getData();
//                String[] filePath = { MediaStore.Images.Media.DATA };
//                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
//                c.moveToFirst();
//                int columnIndex = c.getColumnIndex(filePath[0]);
//                String picturePath = c.getString(columnIndex);
//                c.close();
//                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
//                Log.w("path of image from gallery......******************.........", picturePath + "");
//                img.setImageBitmap(thumbnail);
//            }
//        }
//    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // TODO Auto-generated method stub
//        getMenuInflater().inflate(R.menu.menu_edit_text_activity, menu);
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_share) {
////            Utils.IntenteShare(this, "مسجاتي", "مسجاتي", ed.getText().toString());
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
