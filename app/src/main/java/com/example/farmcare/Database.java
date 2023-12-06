package com.example.farmcare;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "create table soiltests(firmname text,address text,package text,price float,contact text,details text)";
        sqLiteDatabase.execSQL(qry2);

        String qry3 = "insert into soiltests(firmname ,address ,package,price,contact,details) values ('SHREE CHAKRAPANI ENVIROMENTAL CONSULTANT','Boisar,Palghar,Mumbai - 401501, Maharashtra, India','Soil Testing Services','6,000','08046054836','Soil Fertility, Heavy Metals in soil, Soil suitability.'),('SHREE CHAKRAPANI ENVIROMENTAL CONSULTANT','Boisar,Palghar,Mumbai - 401501, Maharashtra, India','Soil Testing Services','6,000','08046054836','Soil Fertility, Heavy Metals in soil, Soil suitability.')";
        sqLiteDatabase.execSQL(qry3);

        String qry4="create table orderplace(username text,pkgname text, firmname text,fullname text,address text,contactno text,price String,date text,time text,otype text)";
        sqLiteDatabase.execSQL(qry4);

        String qry5 = "create table fertilizers(firmname text,address text,product text,price float,contact text)";
        sqLiteDatabase.execSQL(qry5);

        String qry6 = "insert into fertilizers(firmname ,address ,product,price,contact) values ('Farm Enterprise','Vatva, Ahmedabad','MIX MICRONUTRIENT LIQUID FERTILIZER(1L)','100','08046054836'),('SUBONEYO Chemicals Pharmaceuticals P Limited','Jalgaon, Maharashtra','Amino Acid Based Organic Fertilizers(1kg)','66','08046054836')";
        sqLiteDatabase.execSQL(qry6);

        String qry7 = "create table seeds(firmname text,address text,product text,price float,contact text)";
        sqLiteDatabase.execSQL(qry7);

        String qry8 = "create table veg_dealers(firmname text,address text,product text,time text,contact text)";
        sqLiteDatabase.execSQL(qry8);

        String qry9 = "create table pul_dealers(firmname text,address text,product text,time text,contact text)";
        sqLiteDatabase.execSQL(qry9);

        String qry10 = "create table Fru_dealers(firmname text,address text,product text,time text,contact text)";
        sqLiteDatabase.execSQL(qry10);

        String qry11 = "create table dealers(firmname text,address text,product text,time text,contact text)";
        sqLiteDatabase.execSQL(qry11);

        String qry12 = "insert into veg_dealers(firmname ,address ,product,time,contact) values ('Rsupermart','Rsupermart G-73/75, Jalgaon MIDC, Jalgaon - 425003 (Jalgaon MIDC)','Tomato,Cabbage,Cauliflower,etc','9am to 8pm','08046054836'),('Shivam Enterprises','Nimbhora Railway Station Khirdi Kh., Khirdi Kh, Khirdi, Jalgaon - 425507','Potato,Cabbage,Ladyfinger,etc','9am-7pm','08046054836'),('Kranti Traders','53, Vasanji Nagar, Jalgaon - 425003','Tomato,Potato,etc','9am-7pm','9284336447')";
        sqLiteDatabase.execSQL(qry12);

        String qry13 = "create table articles(headline text,discription text)";
        sqLiteDatabase.execSQL(qry13);

        String qry14 = "insert into articles(headline,discription) values ('Organic Food & Farming Report Outlines Opportunities for the Farm Bill','A new report details the benefits of organic farming and outlines strategies to expand organic agriculture practices through the 2023 Farm Bill. The report is a product of the National Resources and Defense Council (NRDC), Swette Center for Sustainable Food Systems at Arizona State University (ASU) and Californians for Pesticide Reform (CPR).'),('India’s Biggest Challenge: The Future of Farming','India is an agricultural country. Agriculture is “only” ~16 % of GDP but the largest sector for employment. Officially farmers are only a few hundred million, but adding family members who help or occasionally farm, as also wage labourers, the number of farm workers is likely to be closer to half a billion people. But how many people would India need farming if it were as labour efficient as the US for growing crops? I am not suggesting it is possible, or even desirable (large, mechanised farms with massive chemical and water inputs) but as a thought exercise? Just four million people. \n" +
                "\n" +
                "The US is extreme; with less than 2% of its population growing food sufficient for almost 2 billion people, but much of it is fed to animals. The US also focuses on many crops suitable for mechanisation, but even using metrics from many East Asian countries, with about 10% of the population in agriculture - as opposed to half the workforce for India - that is hundreds of millions of people who could shift to alternative options.'),('Organic farming in India','Food quality and safety are the primary concerns of Indian consumers today. The growing environmental and food safety concerns have created a significant demand for yield from green and sustainable cultivation methods. Modern farming methods often lead to biodiversity loss and monoculture, which are huge factors in the environment’s decline. Pesticides and chemical usage are rampant in Indian agriculture, causing water and soil contamination.\n" +
                "\n" +
                "Considering this, companies are prioritising organic farming, which is one of the most effective ways to not only provide food security and improve farmers’ livelihoods but also eliminate the use of harmful chemicals. An organic agricultural system promotes and enhances the health of the agroecosystem, including biodiversity, biological cycles, and soil biological activities. It helps reduce greenhouse gas emissions, encourages soil &amp; water conservation, and improves crop yields.\n" +
                "\n" +
                "Due to this, the industry has been steadily shifting from traditional farming to organic and sustainable farming methods. Organic farming immensely contributes to the overall economy, ecology, and social welfare improvement.')";
        sqLiteDatabase.execSQL(qry14);

        String qry15 = "insert into Fru_dealers(firmname ,address ,product,time,contact) values ('Chaitanya Banana Group','Grampanchayat, Near Bajar, Khiroda Pr Yawal, Jalgaon - 425504 (Khiroda)','Apple,Banana,Watermelon,etc','9am to 9pm','08046054836'),('Shivam Enterprises','Nimbhora Railway Station Khirdi Kh., Khirdi Kh, Khirdi, Jalgaon - 425507','watermelon,banana,etc','9am-7pm','08046054836'),('Kranti Traders','53, Vasanji Nagar, Jalgaon - 425003','papayas,banana,etc','9am-7pm','9284336447')";
        sqLiteDatabase.execSQL(qry15);

        String qry16 = "insert into pul_dealers(firmname ,address ,product,time,contact) values ('Sarvaday Agro  Industries','Plot No D 52, Jalgaon MIDC, Jalgaon - 425003','moong,chana,tur,etc','9am to 9pm','08046054836'),('Sriram Canvassing','Dana Bazar, Jalgaon - 425001','moong,chana,tur,etc','9am-7pm','08046054836'),('Kranti Traders','53, Vasanji Nagar, Jalgaon - 425003','moong,chana,tur,etc','9am-7pm','9284336447')";
        sqLiteDatabase.execSQL(qry16);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username,String email,String password)
    {
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }
    public int login(String username,String password)
    {
        int result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }

    public ArrayList getSoilTestDetails(){
        ArrayList<String> arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from soiltests",null );
        if(c.moveToFirst()){
            do{
                System.out.println(c.getString(1));
                arr.add(c.getString(0)+"$"+c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getInt(4)+"$"+c.getString(5));
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }

    public void addOrder(String username,String pkgname,String firmname,String fullname ,String address,String contactno ,String price,String date,String time,String otype){
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("pkgname",pkgname);
        cv.put("firmname",firmname);
        cv.put("fullname",fullname);
        cv.put("address",address);
        cv.put("contactno",contactno);
        cv.put("price",price);
        cv.put("date",date);
        cv.put("time",time);
        cv.put("otype",otype);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("orderplace",null,cv);
        db.close();
        System.out.println("data inserted");
    }

    public ArrayList getOrderData(String username){
        ArrayList<String> arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String str[]=new String[1];
        str[0]=username;
        Cursor c=db.rawQuery("select * from  orderplace where username=?",str);
        if(c.moveToFirst()){
            do{
                System.out.println(c.getString(0));
                arr.add(c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getString(4)+"$"+c.getInt(5)+"$"+c.getString(6)+"$"+c.getString(7)+"$"+c.getFloat(8));
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }

    public ArrayList getProductList(String tablename){
        ArrayList<String> arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from "+tablename,null);
        if(c.moveToFirst()){
            do{
                System.out.println(c.getString(4));
                arr.add(c.getString(0)+"$"+c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getInt(4));
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }

    public ArrayList getArticlesList(){
        ArrayList<String> arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from articles",null);
        if(c.moveToFirst()){
            do{
                System.out.println(c.getString(0));
                arr.add(c.getString(0)+"$"+c.getString(1));
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }

}
