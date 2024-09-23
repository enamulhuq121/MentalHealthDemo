package forms_datamodel;

import android.content.Context;
 import android.annotation.SuppressLint;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Map;
 import java.util.HashMap;
 import Utility.AuditTrial;
 import Common.Global;
 import android.content.ContentValues;

 public class ScreeningChild_DataModel{

        private String _uuid = "";
        public String getuuid(){
              return _uuid;
         }
        public void setuuid(String newValue){
              _uuid = newValue;
         }
        private String _MEMID = "";
        public String getMEMID(){
              return _MEMID;
         }
        public void setMEMID(String newValue){
              _MEMID = newValue;
         }
        private String _Q01 = "";
        public String getQ01(){
              return _Q01;
         }
        public void setQ01(String newValue){
              _Q01 = newValue;
         }
        private String _Q02Date = "";
        public String getQ02Date(){
              return _Q02Date;
         }
        public void setQ02Date(String newValue){
              _Q02Date = newValue;
         }
        private String _Q02Y = "";
        public String getQ02Y(){
              return _Q02Y;
         }
        public void setQ02Y(String newValue){
              _Q02Y = newValue;
         }
        private String _Q03 = "";
        public String getQ03(){
              return _Q03;
         }
        public void setQ03(String newValue){
              _Q03 = newValue;
         }
        private String _Q04 = "";
        public String getQ04(){
              return _Q04;
         }
        public void setQ04(String newValue){
              _Q04 = newValue;
         }
        private String _Q05 = "";
        public String getQ05(){
              return _Q05;
         }
        public void setQ05(String newValue){
              _Q05 = newValue;
         }
        private String _Q06 = "";
        public String getQ06(){
              return _Q06;
         }
        public void setQ06(String newValue){
              _Q06 = newValue;
         }
        private String _Q07 = "";
        public String getQ07(){
              return _Q07;
         }
        public void setQ07(String newValue){
              _Q07 = newValue;
         }
        private String _StartTime = "";
        public void setStartTime(String newValue){
              _StartTime = newValue;
         }
        private String _EndTime = "";
        public void setEndTime(String newValue){
              _EndTime = newValue;
         }
        private String _DeviceID = "";
        public void setDeviceID(String newValue){
              _DeviceID = newValue;
         }
        private String _EntryUser = "";
        public void setEntryUser(String newValue){
              _EntryUser = newValue;
         }
        private String _Lat = "";
        public void setLat(String newValue){
              _Lat = newValue;
         }
        private String _Lon = "";
        public void setLon(String newValue){
              _Lon = newValue;
         }
        private String _EnDt = Global.DateTimeNowYMDHMS();
        private int _Upload = 2;
        private String _modifyDate = Global.DateTimeNowYMDHMS();

        String TableName = "ScreeningChild";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where uuid='"+ _uuid +"' and MEMID='"+ _MEMID +"' "))
                    response = UpdateData(context);
                 else
                    response = SaveData(context);
            }
            catch(Exception  e)
            {
                 response = e.getMessage();
            }
           return response;
        }
        Connection C;

        private String SaveData(Context context)
        {
            String response = "";
            C = new Connection(context);
            try
              {
                 ContentValues contentValues = new ContentValues();
                 contentValues.put("uuid", _uuid);
                 contentValues.put("MEMID", _MEMID);
                 contentValues.put("Q01", _Q01);
                 contentValues.put("Q02Date", _Q02Date);
                 contentValues.put("Q02Y", _Q02Y);
                 contentValues.put("Q03", _Q03);
                 contentValues.put("Q04", _Q04);
                 contentValues.put("Q05", _Q05);
                 contentValues.put("Q06", _Q06);
                 contentValues.put("Q07", _Q07);
                 contentValues.put("isdelete", 2);
                 contentValues.put("StartTime", _StartTime);
                 contentValues.put("EndTime", _EndTime);
                 contentValues.put("DeviceID", _DeviceID);
                 contentValues.put("EntryUser", _EntryUser);
                 contentValues.put("Lat", _Lat);
                 contentValues.put("Lon", _Lon);
                 contentValues.put("EnDt", _EnDt);
                 contentValues.put("Upload", _Upload);
                 contentValues.put("modifyDate", _modifyDate);
                 C.InsertData(TableName, contentValues);
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }

        private String UpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            try
              {
                 ContentValues contentValues = new ContentValues();
                 contentValues.put("uuid", _uuid);
                 contentValues.put("MEMID", _MEMID);
                 contentValues.put("Q01", _Q01);
                 contentValues.put("Q02Date", _Q02Date);
                 contentValues.put("Q02Y", _Q02Y);
                 contentValues.put("Q03", _Q03);
                 contentValues.put("Q04", _Q04);
                 contentValues.put("Q05", _Q05);
                 contentValues.put("Q06", _Q06);
                 contentValues.put("Q07", _Q07);
                 contentValues.put("Upload", _Upload);
                 contentValues.put("modifyDate", _modifyDate);
                 C.UpdateData(TableName, "uuid,MEMID", (""+ _uuid +", "+ _MEMID +""), contentValues);


              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        int Count = 0;
        private int _Count = 0;
        public int getCount(){ return _Count; }

        @SuppressLint("Range")
        public List<ScreeningChild_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<ScreeningChild_DataModel> data = new ArrayList<ScreeningChild_DataModel>();
            ScreeningChild_DataModel d = new ScreeningChild_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                Count += 1;
                d = new ScreeningChild_DataModel();
                d._Count = Count;
                d._uuid = cur.getString(cur.getColumnIndex("uuid"));
                d._MEMID = cur.getString(cur.getColumnIndex("MEMID"));
                d._Q01 = cur.getString(cur.getColumnIndex("Q01"));
                d._Q02Date = cur.getString(cur.getColumnIndex("Q02Date"));
                d._Q02Y = cur.getString(cur.getColumnIndex("Q02Y"));
                d._Q03 = cur.getString(cur.getColumnIndex("Q03"));
                d._Q04 = cur.getString(cur.getColumnIndex("Q04"));
                d._Q05 = cur.getString(cur.getColumnIndex("Q05"));
                d._Q06 = cur.getString(cur.getColumnIndex("Q06"));
                d._Q07 = cur.getString(cur.getColumnIndex("Q07"));
                data.add(d);



                cur.moveToNext();
            }
            cur.close();
          return data;
        }




 }