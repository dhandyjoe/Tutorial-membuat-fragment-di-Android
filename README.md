# fragment-android

#### PREVIEW APP :
![tutorial-fragment](https://user-images.githubusercontent.com/68207916/110053602-4fa46780-7d8c-11eb-9e91-a9741147e8eb.gif)

<br>

### Tutorial membuat Fragment pada Android
##### 1.  Sync ViewBinding pada build.gradle

    android {
      ...
      viewBinding {
        enabled = true
      }
    }

    
Lalu klik 'sync now' pada kanan atas 
    
##### 2.  Buat 3 fragment blank file
          - Contact Fragment
          - Message Fragment
          - Status Fragment

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
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
