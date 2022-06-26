package com.example.bitirmeprojesimytravel;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeActivity extends AppCompatActivity {

    DatabaseReference databaseReference; //firebase bağlanmak için
    List<Place> placeList;

    public ImageView img_HistoricalPlaces;
    public ImageView img_rest;
    public ImageView img_Emergency;
    public ImageView img_hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        placeList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("places"); //firebasede places alanına ulaşmak için yazdık
        databaseReference.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean placeNext = snapshot.getChildren().iterator().hasNext(); //iteratorbütün ögeleri tarayacak biçimde tekrarlayan eylem
                if(placeNext){
                    for (DataSnapshot canliSnapshot : snapshot.getChildren()) {   //places içine bakıp içi boş ise alt tarafa else iniyor
                        Place place = canliSnapshot.getValue(Place.class);     //snapshot verininin anlık görüntüsünü verir
                        placeList.add(place);
                    }
                    prepareView();   // Ekranı hazırlıyor ve tıklama event tanımlandığı yer
                }else{
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fgrandbazaar.jpg?alt=media&token=db7307de-0bdc-44d1-95b9-5459e60597e6","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fgrandbazaarinfo.jpg?alt=media&token=3c740d21-b703-47b3-baab-0dee8b0e94f6","41.017452576651145, 28.973089190584595","1","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fgrandbazaarvoice.mp3?alt=media&token=b5346c59-520a-4c75-b57d-20c44fa697fd");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fthebasilicacistern.jpg?alt=media&token=88bd15cc-fd84-446f-b076-c2d3f96d354b","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fthebalisicacisterninfo.jpg?alt=media&token=233c1146-3c0d-4a84-8ca4-3d00b2746e0b","41.00835976335377, 28.977840123246057","1", "https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fcisternvoice.mp3?alt=media&token=e957ed2c-fe99-4d85-9ffa-7bb5cc7fa3df");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fgalatakulesi.jpg?alt=media&token=0dc92d9c-4e52-4e96-a6a7-b985526b9da5","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fgalatatowerinfo.jpg?alt=media&token=ed6c1000-ba31-472d-8d8f-669fcfa9bf99","41.0255573774376, 28.97426311684017","1", "https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fmadienstowervoice.mp3?alt=media&token=0322a4f3-14fe-4619-b278-a4f8cd2b06e9");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fhagiasophia.jpg?alt=media&token=fc96061f-f9fe-42f9-80d1-d4a1118e3dfb","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fhagiasophiainfo.jpg?alt=media&token=a24a8e9d-a34a-4d0e-88f1-10fad46e6f10","41.00857488320332, 28.980174997703312","1","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fhagiasophiavoice.mp3?alt=media&token=89dbf862-4c90-4907-a5bb-e02d54855ae4");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fdolmabahceplace.jpg?alt=media&token=194fc328-cb82-4143-9c31-2ce7c5e3b19c","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fdolmabahceinfo.jpg?alt=media&token=2e3dffd5-fc28-4ace-be62-9e82e2ecbb4c","41.03915618695886, 29.00045939770404","1","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fdolmabahcevoice.mp3?alt=media&token=2feae4ae-b73b-4a8c-8e23-88ef2cd1bc7f");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fbosphorus.jpg?alt=media&token=7a509546-dceb-4bb6-b762-964db8e5ac3d","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fbosphorusinfo.jpg?alt=media&token=dc1ef9f6-9744-4a6b-9315-cd0a6bd0630d","41.221549732940474, 29.12886849979358","1","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fbosphorusvoice.mp3?alt=media&token=066458a7-4d0e-4620-a78e-b2e50d33cc3f");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Ftopkapisarayi.jpg?alt=media&token=36275b82-f3d4-4881-82cc-a2dc062967cc","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Ftopkapiinfo.jpg?alt=media&token=cd9ccb8e-fa16-4c06-9f63-ce3cba6d2f77","41.0115194793043, 28.983378897703414","1","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fmadienstowervoice.mp3?alt=media&token=0322a4f3-14fe-4619-b278-a4f8cd2b06e9");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fbluemosque.jpg?alt=media&token=92f0c6fb-fdc0-4257-a093-92b5b217d620","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fbluemosquinfo.jpg?alt=media&token=c4b75ed9-0140-43d6-8951-391ed06e9e2d","41.00540957930479, 28.976813797703254","1","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fmadienstowervoice.mp3?alt=media&token=0322a4f3-14fe-4619-b278-a4f8cd2b06e9");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fmaidenstower.jpg?alt=media&token=a0792dde-5e8e-40b2-be21-941adc6c73a4","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fmadienstowerinfo.jpg?alt=media&token=9c8dbb12-2331-4bee-9c00-d66e5b5cb080","41.0211215793032, 29.00409976886864","1","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/sounds%2Fmadienstowervoice.mp3?alt=media&token=0322a4f3-14fe-4619-b278-a4f8cd2b06e9");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fnusret.jpg?alt=media&token=42aa7920-75d7-4913-a0e3-07fb0aee2395","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fnusretbilgii.jpg?alt=media&token=9096aaee-061c-4fb3-8ac4-d4c09ef77de1","41.0807721916886, 29.033391782469714","2","");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fcznburak.jpg?alt=media&token=c8ea6f19-216f-48df-9f80-2c66b32f7aac","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fcznburakbilgii.jpg?alt=media&token=087c1915-feb6-4eeb-8999-b752a8687b9b","41.075434147450615, 29.018120613563568","2","");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fcigeristanresim.jpg?alt=media&token=57fefdaf-fd85-498f-8995-e4bf553973d1","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fcigeristanbilgii.jpg?alt=media&token=559e6488-a6e3-426b-aff8-f47c52589f39","41.000165785686605, 28.800507635308715","2","");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fercansteak.jpg?alt=media&token=e3183fbd-14cf-4758-85ef-fd5c3326ab2f","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fercanburger.jpg?alt=media&token=b1346061-d5dc-47de-a2de-30f2c08127be","41.088293679191096, 28.802633326867245","2","");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fhacibaba.jpg?alt=media&token=bf36cb30-41f5-4530-ba64-36c04861cbe2","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fhacibababilgiiiiii.jpg?alt=media&token=eb20062e-765a-4192-93b9-937ff69ea237","39.95087044977019, 32.83153278682947","2","");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fperapalace.jpg?alt=media&token=d8933179-8458-4da6-9790-743599adf49c","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fperapalacebilgii.jpg?alt=media&token=b3ac1639-beb5-424d-a30b-04cb49c5e86f","41.030995949375075, 28.97361769348584","3","");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fwaltongalata.jpg?alt=media&token=6972bc92-ce5b-40b1-a73b-a1bc5a819cbc","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fwaltongalatabilgii.jpg?alt=media&token=7fc6bc7a-3a1c-4b1e-a3e3-2a3c5f2d5fe1","41.02585552787451, 28.972327040967052","3","");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fhennahotel.jpg?alt=media&token=3b7d4c72-7978-4fa9-8e35-5d7d2b2524f5","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fhennahotelbilgiiii.jpg?alt=media&token=35211627-6c9e-4d32-b3de-3632c1fa73c8","41.0060318239232, 28.98097202666867","3","");
                    addPlace("https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fmandarinhotel.jpg?alt=media&token=14c57147-7ef9-45b0-97d5-5865d75bbab7","https://firebasestorage.googleapis.com/v0/b/bitirmeprojesimytravel.appspot.com/o/photo%2Fplaces%2Fmandarinbilgii.jpg?alt=media&token=7e268c35-653e-4a5d-9f31-462e745c6eff","41.057027369441805, 29.03561633341732","3","");

                      // Else gelip listin içini dolduruyor
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void prepareView(){   //ekranı hazırlıyor
        img_HistoricalPlaces=findViewById(R.id.img_HistoricalPlaces);
        img_HistoricalPlaces.setOnClickListener(view -> {
            List<Place> places = placeList.stream().filter(place -> place.placeType.equals("1")).collect(Collectors.toList());
            Intent intent = new Intent(HomeActivity.this,historicalplaces.class); //type 1 olanları hangi sayfaya akrılacağını gösteriyoruz
            intent.putExtra("DATA", (Serializable) places);
            startActivity(intent);
        });

        img_rest=findViewById(R.id.img_rest);
        img_rest.setOnClickListener(view -> {
            List<Place> places = placeList.stream().filter(place -> place.placeType.equals("2")).collect(Collectors.toList());
            Intent intent = new Intent(HomeActivity.this,RestorantListActivity.class);
            intent.putExtra("DATA", (Serializable) places);
            startActivity(intent);
        });

        img_hotel=findViewById(R.id.img_hotel);
        img_hotel.setOnClickListener(view -> {
            List<Place> places = placeList.stream().filter(place -> place.placeType.equals("3")).collect(Collectors.toList());
            Intent intent = new Intent(HomeActivity.this,HotelListActivity.class);
            intent.putExtra("DATA", (Serializable) places);
            startActivity(intent);
        });

        img_Emergency=findViewById(R.id.imgEmergency);
        img_Emergency.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, emergency.class);
            startActivity(intent);

        });

    }
    private void addPlace(String listPhoto, String detailPhoto, String coordinate, String placeType, String sound){
        String id = databaseReference.push().getKey();
        Place place = new Place(id,listPhoto,detailPhoto,coordinate,placeType,sound);   //plac oluşturup database gönderdik
        databaseReference.child(id).setValue(place);
    }
}