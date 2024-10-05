
 package forms_activity;


 import android.annotation.SuppressLint;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.HashMap;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.location.Location;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.View;
 import android.view.MotionEvent;
 import android.widget.AdapterView;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.SimpleAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;
 import android.widget.ArrayAdapter;
 import android.graphics.Color;
 import android.view.WindowManager;
 import androidx.constraintlayout.widget.ConstraintLayout;
 import android.widget.AutoCompleteTextView;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.content.ContextCompat;
 import forms_datamodel.ScreeningMother_DataModel;
 import Utility.*;
 import Common.*;
 import android.widget.Toast;
 import android.text.TextWatcher;
 import android.widget.CompoundButton;
 import android.text.Editable;

 import org.icddrb.mental_health_survey.R;

 public class ScreeningMother extends AppCompatActivity {
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override 
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME) 
             { return false; }
        else { return true;  }
    }

    boolean networkAvailable=false;
    Location currentLocation; 
    double currentLatitude,currentLongitude; 
    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    TextView lblHeading;
    LinearLayout secuuid;
    View lineuuid;
    TextView lbluuid;
    TextView Vlbluuid;
    EditText txtuuid;
    LinearLayout secMEMID;
    View lineMEMID;
    TextView lblMEMID;
    TextView VlblMEMID;
    EditText txtMEMID;
    LinearLayout seclbl2;
    View linelbl2;
    LinearLayout secQ01;
    View lineQ01;
    TextView lblQ01;
    TextView VlblQ01;
    RadioGroup rdogrpQ01;
    RadioButton rdoQ011;
    RadioButton rdoQ012;
    LinearLayout secQ02;
    View lineQ02;
    TextView lblQ02;
    TextView VlblQ02;
    RadioGroup rdogrpQ02;
    RadioButton rdoQ021;
    RadioButton rdoQ022;
    LinearLayout secQ03;
    View lineQ03;
    TextView lblQ03;
    TextView VlblQ03;
    RadioGroup rdogrpQ03;
    RadioButton rdoQ031;
    RadioButton rdoQ032;
    LinearLayout secQ04;
    View lineQ04;
    TextView lblQ04;
    TextView VlblQ04;
    RadioGroup rdogrpQ04;
    RadioButton rdoQ041;
    RadioButton rdoQ042;
    LinearLayout secQ05;
    View lineQ05;
    TextView lblQ05;
    TextView VlblQ05;
    RadioGroup rdogrpQ05;
    RadioButton rdoQ051;
    RadioButton rdoQ052;

    static int MODULEID   = 0;
    static int LANGUAGEID = 0;
    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String UUID = "";
    static String MEMID = "";

 @SuppressLint("ClickableViewAccessibility")
 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.screeningmother);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = MySharedPreferences.getValue(this, "deviceid");
         ENTRYUSER = MySharedPreferences.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         UUID = IDbundle.getString("uuid");
         MEMID = IDbundle.getString("MEMID");

         TableName = "ScreeningMother";
         MODULEID = 11;
         LANGUAGEID = Integer.parseInt(MySharedPreferences.getValue(this, "languageid"));
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(ScreeningMother.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

        Initialization();
        Connection.LocalizeLanguage(ScreeningMother.this, MODULEID, LANGUAGEID);





         //Hide all skip variables
         secQ02.setVisibility(View.GONE);
         lineQ02.setVisibility(View.GONE);
         secQ03.setVisibility(View.GONE);
         lineQ03.setVisibility(View.GONE);
         secQ04.setVisibility(View.GONE);
         lineQ04.setVisibility(View.GONE);
         secQ05.setVisibility(View.GONE);
         lineQ05.setVisibility(View.GONE);
         secQ03.setVisibility(View.GONE);
         lineQ03.setVisibility(View.GONE);
         secQ04.setVisibility(View.GONE);
         lineQ04.setVisibility(View.GONE);
         secQ05.setVisibility(View.GONE);
         lineQ05.setVisibility(View.GONE);
         secQ04.setVisibility(View.GONE);
         lineQ04.setVisibility(View.GONE);
         secQ05.setVisibility(View.GONE);
         lineQ05.setVisibility(View.GONE);
         secQ05.setVisibility(View.GONE);
         lineQ05.setVisibility(View.GONE);


        DataSearch(UUID,MEMID);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});


     }
     catch(Exception  e)
     {
         Connection.MessageBox(ScreeningMother.this, e.getMessage());
         return;
     }
 }

 @SuppressLint("ClickableViewAccessibility")
 private void Initialization()
 {
   try
     {
         secuuid = findViewById(R.id.secuuid);
         lineuuid = findViewById(R.id.lineuuid);
         lbluuid = findViewById(R.id.lbluuid);
         Vlbluuid = findViewById(R.id.Vlbluuid);
         txtuuid = findViewById(R.id.txtuuid);
        /* if (UUID.length() == 0) txtuuid.setText(Global.Get_UUID());
         else txtuuid.setText(UUID); 
         txtuuid.setEnabled(false);
         secuuid.setVisibility(View.GONE);*/
         secMEMID = findViewById(R.id.secMEMID);
         lineMEMID = findViewById(R.id.lineMEMID);
         lblMEMID = findViewById(R.id.lblMEMID);
         VlblMEMID = findViewById(R.id.VlblMEMID);
         txtMEMID = findViewById(R.id.txtMEMID);
         /*if (MEMID.length() == 0) txtMEMID.setText(Global.Get_UUID());
         else txtMEMID.setText(MEMID); 
         txtMEMID.setEnabled(false);*/
         secMEMID.setVisibility(View.GONE);
         seclbl2=findViewById(R.id.seclbl2);
         linelbl2=findViewById(R.id.linelbl2);
         secQ01 = findViewById(R.id.secQ01);
         lineQ01 = findViewById(R.id.lineQ01);
         lblQ01 =  findViewById(R.id.lblQ01);
         VlblQ01 =  findViewById(R.id.VlblQ01);
         rdogrpQ01 =  findViewById(R.id.rdogrpQ01);
         rdoQ011 =  findViewById(R.id.rdoQ011);
         rdoQ012 =  findViewById(R.id.rdoQ012);
         rdogrpQ01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpQ01 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpQ01.getChildCount(); i++)
             {
               rb = (RadioButton) rdogrpQ01.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpQ01[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secQ02.setVisibility(View.GONE);
                    lineQ02.setVisibility(View.GONE);
                    rdogrpQ02.clearCheck();
                    secQ03.setVisibility(View.GONE);
                    lineQ03.setVisibility(View.GONE);
                    rdogrpQ03.clearCheck();
                    secQ04.setVisibility(View.GONE);
                    lineQ04.setVisibility(View.GONE);
                    rdogrpQ04.clearCheck();
                    secQ05.setVisibility(View.GONE);
                    lineQ05.setVisibility(View.GONE);
                    rdogrpQ05.clearCheck();
             }
             else
             {
                    secQ02.setVisibility(View.VISIBLE);
                    lineQ02.setVisibility(View.VISIBLE);
                    secQ03.setVisibility(View.VISIBLE);
                    lineQ03.setVisibility(View.VISIBLE);
                    secQ04.setVisibility(View.VISIBLE);
                    lineQ04.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secQ02 = findViewById(R.id.secQ02);
         lineQ02 = findViewById(R.id.lineQ02);
         lblQ02 =  findViewById(R.id.lblQ02);
         VlblQ02 =  findViewById(R.id.VlblQ02);
         rdogrpQ02 =  findViewById(R.id.rdogrpQ02);
         rdoQ021 =  findViewById(R.id.rdoQ021);
         rdoQ022 =  findViewById(R.id.rdoQ022);
         rdogrpQ02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpQ02 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpQ02.getChildCount(); i++)
             {
               rb = (RadioButton) rdogrpQ02.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpQ02[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secQ03.setVisibility(View.GONE);
                    lineQ03.setVisibility(View.GONE);
                    rdogrpQ03.clearCheck();
                    secQ04.setVisibility(View.GONE);
                    lineQ04.setVisibility(View.GONE);
                    rdogrpQ04.clearCheck();
                    secQ05.setVisibility(View.GONE);
                    lineQ05.setVisibility(View.GONE);
                    rdogrpQ05.clearCheck();
             }
             else
             {
                    secQ03.setVisibility(View.VISIBLE);
                    lineQ03.setVisibility(View.VISIBLE);
                    secQ04.setVisibility(View.VISIBLE);
                    lineQ04.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secQ03 = findViewById(R.id.secQ03);
         lineQ03 = findViewById(R.id.lineQ03);
         lblQ03 =  findViewById(R.id.lblQ03);
         VlblQ03 =  findViewById(R.id.VlblQ03);
         rdogrpQ03 =  findViewById(R.id.rdogrpQ03);
         rdoQ031 =  findViewById(R.id.rdoQ031);
         rdoQ032 =  findViewById(R.id.rdoQ032);
         rdogrpQ03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpQ03 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpQ03.getChildCount(); i++)
             {
               rb = (RadioButton) rdogrpQ03.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpQ03[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secQ04.setVisibility(View.GONE);
                    lineQ04.setVisibility(View.GONE);
                    rdogrpQ04.clearCheck();
                    secQ05.setVisibility(View.GONE);
                    lineQ05.setVisibility(View.GONE);
                    rdogrpQ05.clearCheck();
             }
             else
             {
                    secQ04.setVisibility(View.VISIBLE);
                    lineQ04.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secQ04 = findViewById(R.id.secQ04);
         lineQ04 = findViewById(R.id.lineQ04);
         lblQ04 =  findViewById(R.id.lblQ04);
         VlblQ04 =  findViewById(R.id.VlblQ04);
         rdogrpQ04 =  findViewById(R.id.rdogrpQ04);
         rdoQ041 =  findViewById(R.id.rdoQ041);
         rdoQ042 =  findViewById(R.id.rdoQ042);
         rdogrpQ04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpQ04 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpQ04.getChildCount(); i++)
             {
               rb = (RadioButton) rdogrpQ04.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpQ04[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secQ05.setVisibility(View.GONE);
                    lineQ05.setVisibility(View.GONE);
                    rdogrpQ05.clearCheck();
             }
             else
             {
                    secQ05.setVisibility(View.VISIBLE);
                    lineQ05.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secQ05 = findViewById(R.id.secQ05);
         lineQ05 = findViewById(R.id.lineQ05);
         lblQ05 =  findViewById(R.id.lblQ05);
         VlblQ05 =  findViewById(R.id.VlblQ05);
         rdogrpQ05 =  findViewById(R.id.rdogrpQ05);
         rdoQ051 =  findViewById(R.id.rdoQ051);
         rdoQ052 =  findViewById(R.id.rdoQ052);
     }
     catch(Exception  e)
     {
         Connection.MessageBox(ScreeningMother.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
         String ValidationMSG = ValidationCheck();
         if(ValidationMSG.length()>0)
         {
         	Connection.MessageBox(ScreeningMother.this, ValidationMSG);
         	return;
         }
 
         String SQL = "";
         RadioButton rb;

         ScreeningMother_DataModel objSave = new ScreeningMother_DataModel();
         objSave.setuuid(txtuuid.getText().toString());
         objSave.setMEMID(txtMEMID.getText().toString());
         String[] d_rdogrpQ01 = new String[] {"1","2"};
         objSave.setQ01("");
         for (int i = 0; i < rdogrpQ01.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpQ01.getChildAt(i);
             if (rb.isChecked()) objSave.setQ01(d_rdogrpQ01[i]);
         }

         String[] d_rdogrpQ02 = new String[] {"1","2"};
         objSave.setQ02("");
         for (int i = 0; i < rdogrpQ02.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpQ02.getChildAt(i);
             if (rb.isChecked()) objSave.setQ02(d_rdogrpQ02[i]);
         }

         String[] d_rdogrpQ03 = new String[] {"1","2"};
         objSave.setQ03("");
         for (int i = 0; i < rdogrpQ03.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpQ03.getChildAt(i);
             if (rb.isChecked()) objSave.setQ03(d_rdogrpQ03[i]);
         }

         String[] d_rdogrpQ04 = new String[] {"1","2"};
         objSave.setQ04("");
         for (int i = 0; i < rdogrpQ04.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpQ04.getChildAt(i);
             if (rb.isChecked()) objSave.setQ04(d_rdogrpQ04[i]);
         }

         String[] d_rdogrpQ05 = new String[] {"1","2"};
         objSave.setQ05("");
         for (int i = 0; i < rdogrpQ05.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpQ05.getChildAt(i);
             if (rb.isChecked()) objSave.setQ05(d_rdogrpQ05[i]);
         }

         objSave.setStartTime(STARTTIME);
         objSave.setEndTime(g.CurrentTime24());
         objSave.setDeviceID(DEVICEID);
         objSave.setEntryUser(ENTRYUSER); //from data entry user list
         objSave.setLat(MySharedPreferences.getValue(this, "lat"));
         objSave.setLon(MySharedPreferences.getValue(this, "lon"));

         String status = objSave.SaveUpdateData(this);
         if(status.length()==0) {
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

           //  Toast.makeText(ScreeningMother.this,"Save Successfully...",Toast.LENGTH_SHORT).show();
             Connection.MessageBox(ScreeningMother.this,"Save Successfully");
             finish();
         }
         else{
             Connection.MessageBox(ScreeningMother.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(ScreeningMother.this, e.getMessage());
         return;
     }
 }

 private String ValidationCheck()
 {
   String ValidationMsg = "";
   String DV = "";
   try
     {
         ResetSectionColor();
         if(txtuuid.getText().toString().length()==0 & secuuid.isShown())
           {
             ValidationMsg += "\n"+ lbluuid.getText().toString() + " Required field: "+ Vlbluuid.getText().toString();
             secuuid.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtMEMID.getText().toString().length()==0 & secMEMID.isShown())
           {
             ValidationMsg += "\n"+ lblMEMID.getText().toString() + " Required field: "+ VlblMEMID.getText().toString();
             secMEMID.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoQ011.isChecked() & !rdoQ012.isChecked() & secQ01.isShown())
           {
             ValidationMsg += "\n"+ lblQ01.getText().toString() + " Required field: "+ VlblQ01.getText().toString();
             secQ01.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoQ021.isChecked() & !rdoQ022.isChecked() & secQ02.isShown())
           {
             ValidationMsg += "\n"+ lblQ02.getText().toString() + " Required field: "+ VlblQ02.getText().toString();
             secQ02.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoQ031.isChecked() & !rdoQ032.isChecked() & secQ03.isShown())
           {
             ValidationMsg += "\n"+ lblQ03.getText().toString() + " Required field: "+ VlblQ03.getText().toString();
             secQ03.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoQ041.isChecked() & !rdoQ042.isChecked() & secQ04.isShown())
           {
             ValidationMsg += "\n"+ lblQ04.getText().toString() + " Required field: "+ VlblQ04.getText().toString();
             secQ04.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoQ051.isChecked() & !rdoQ052.isChecked() & secQ05.isShown())
           {
             ValidationMsg += "\n"+ lblQ05.getText().toString() + " Required field: "+ VlblQ05.getText().toString();
             secQ05.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
     }
     catch(Exception  e)
     {
         ValidationMsg += "\n"+ e.getMessage();
     }

     return ValidationMsg;
 }

 private void ResetSectionColor()
 {
   try
     {
             secuuid.setBackgroundColor(Color.WHITE);
             secMEMID.setBackgroundColor(Color.WHITE);
             secQ01.setBackgroundColor(Color.WHITE);
             secQ02.setBackgroundColor(Color.WHITE);
             secQ03.setBackgroundColor(Color.WHITE);
             secQ04.setBackgroundColor(Color.WHITE);
             secQ05.setBackgroundColor(Color.WHITE);
     }
     catch(Exception  e)
     {
     }
 }

 private void DataSearch(String uuid, String MEMID)
     {
       try
        {     
           RadioButton rb;
           ScreeningMother_DataModel d = new ScreeningMother_DataModel();
           String SQL = "Select * from "+ TableName +"  Where uuid='"+ uuid +"' and MEMID='"+ MEMID +"'";
           List<ScreeningMother_DataModel> data = d.SelectAll(this, SQL);
           for(ScreeningMother_DataModel item : data){
             txtuuid.setText(item.getuuid());
             txtMEMID.setText(item.getMEMID());
             String[] d_rdogrpQ01 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpQ01.length; i++)
             {
                 if (String.valueOf(item.getQ01()).equals(String.valueOf(d_rdogrpQ01[i])))
                 {
                     rb = (RadioButton) rdogrpQ01.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpQ02 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpQ02.length; i++)
             {
                 if (String.valueOf(item.getQ02()).equals(String.valueOf(d_rdogrpQ02[i])))
                 {
                     rb = (RadioButton) rdogrpQ02.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpQ03 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpQ03.length; i++)
             {
                 if (String.valueOf(item.getQ03()).equals(String.valueOf(d_rdogrpQ03[i])))
                 {
                     rb = (RadioButton) rdogrpQ03.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpQ04 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpQ04.length; i++)
             {
                 if (String.valueOf(item.getQ04()).equals(String.valueOf(d_rdogrpQ04[i])))
                 {
                     rb = (RadioButton) rdogrpQ04.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpQ05 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpQ05.length; i++)
             {
                 if (String.valueOf(item.getQ05()).equals(String.valueOf(d_rdogrpQ05[i])))
                 {
                     rb = (RadioButton) rdogrpQ05.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(ScreeningMother.this, e.getMessage());
            return;
        }
     }



 protected Dialog onCreateDialog(int id) {
   final Calendar c = Calendar.getInstance();
   hour = c.get(Calendar.HOUR_OF_DAY);
   minute = c.get(Calendar.MINUTE);
   switch (id) {
       case DATE_DIALOG:
           return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);
       case TIME_DIALOG:
           return new TimePickerDialog(this, timePickerListener, hour, minute,false);
       }
     return null;
 }

 private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
      mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
      EditText txtDate;


      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;

    }
  };


 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
 }
}