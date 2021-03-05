# fragment-android

#### PREVIEW APP :
![tutorial-fragment](https://user-images.githubusercontent.com/68207916/110053602-4fa46780-7d8c-11eb-9e91-a9741147e8eb.gif)

<br>

### Tutorial membuat Fragment pada Android
##### 1.  Sync ViewBinding pada build.gradle
> Fungsi dari View Binding adalah untuk mengakses view yang ada pada Layout .xml
> 
> Menggantikan findViewById, Kotlin Synthetic
> 
> Direkomendasikan oleh Google

    android {
      ...
      viewBinding {
        enabled = true
      }
    }

    
--->    Lalu klik 'sync now' pada kanan atas 

![Screenshot from 2021-03-05 09-11-01](https://user-images.githubusercontent.com/68207916/110057208-c80e2700-7d92-11eb-968f-656926acc168.png)

    
##### 2.  Buat 3 fragment blank file
+ Contact Fragment
+ Message Fragment
+ Status Fragment

##### 3.  Inisialisasi ViewBinding pada Activity dan Fragment
- Activity
```
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
```
          
- Fragment
```
class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

      override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                    savedInstanceState: Bundle?): View? {

      binding = FragmentContactBinding.inflate(inflater, container,  false)
      return binding.root
    }  
}
```

##### 4.  Copy Paste .xml
* activity_main.xml
```
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".activity.MainActivity">

        <com.google.android.material.tabs.TabLayout
            android:id="@+id/tabLayout"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="#075e54"
            app:tabIndicatorColor="#FFFFFF"
            app:tabTextColor="#fff"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <androidx.viewpager.widget.ViewPager
            android:id="@+id/viewPager"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tabLayout"/>

    </androidx.constraintlayout.widget.ConstraintLayout>
```
* fragment_contact.xml
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ContactFragment">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:textSize="20sp"
        android:textStyle="bold"
        android:text="Fragment Contact" />

</FrameLayout>
```

* fragment_message.xml
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MessageFragment">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:textSize="20sp"
        android:textStyle="bold"
        android:text="Fragment Message" />

</FrameLayout>
```

* fragment_status.xml
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".StatusFragment">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:textSize="20sp"
        android:textStyle="bold"
        android:text="Fragment Status" />

</FrameLayout>
```

##### 5.  Buat class adapter untuk ViewPager-nya --> beri nama ViewPagerAdapter
---> Class ini berguna untuk menghubungkan tablayout dengan view pagernya, sekaligus menambahkan fitur slide didalamnya

```
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val contactFragment = ContactFragment()
    val messageFragment = MessageFragment()
    val statusFragment = StatusFragment()

    override fun getCount(): Int { // function ini digunakan untuk mengembalikan jumlah fragment yang ada
        return 3
    }

    override fun getItem(position: Int): Fragment { // function ini digunakan untuk set tampilan fragment yang dibutuhkan
        when(position) {
            0 -> return contactFragment
            1 -> return messageFragment
            2 -> return statusFragment
        }
        return contactFragment
    }

    override fun getPageTitle(position: Int): CharSequence? { // function ini digunakan untuk membuat judul pada tab layout
        when (position) {
            0 -> return "Contact"
            1 -> return "Message"
            2 -> return "Status"
        }
        return null
    }
}
```

##### 6.  Deklarasi ViewPager di MainActivity
```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ...
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.setAdapter(viewPagerAdapter)
        binding.viewPager.setCurrentItem(1) // digunakan untuk set first page saat pertama kali aplikasi dibuka
    }
}
```



          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
