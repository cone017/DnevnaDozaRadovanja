import android.content.Context
import com.example.dnevnadozaradovanja.MyAdapter
import com.example.dnevnadozaradovanja.MyDataItem
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
class YourClassTest {

    @Mock
    private lateinit var context: Context

    private lateinit var adapter: MyAdapter

    private val testData = listOf(
        MyDataItem(1500, "Srpsko-srpski recnik prva sveska", "https://radovandamjanovic.rs/slike/srpsko-srpski-prva-radovan-damjanovic.jpg", 251),
        MyDataItem(1300, "Srpsko-srpski recnik druga sveska", "https://radovandamjanovic.rs/slike/srpsko-srpski-druga-radovan-damjanovic.jpg", 243),
        MyDataItem(1400, "Srpsko-srpski recnik treca sveska", "https://radovandamjanovic.rs/slike/srpsko-srpski-treca-radovan-damjanovic.jpg", 250),
        MyDataItem(1170, "Zrnov, srpski Avalon", "https://radovandamjanovic.rs/slike/zrnov-radovan-damjanovic.jpg", 69),
        MyDataItem(1670, "Kula kralja Milutina", "https://radovandamjanovic.rs/slike/kula-kralja-milutina-radovan-damjanovic.jpg", 78),
        MyDataItem(1340, "Rimljani Slovenstvujuci", "https://radovandamjanovic.rs/slike/rimljani-radovan-damjanovic.jpg", 149),
        MyDataItem(2000, "Nemanjici: Vladari i vreme srpskog srednjeg veka", "https://www.serbianshop.com/uploads/store/products/images/nemanjici-vladari-i-vreme-srpskog-srednjeg-veka-dusko-lopandic-6560868cb74b4.webp", 256),
        MyDataItem(800, "Srpski viteski kod", "https://www.serbianshop.com/uploads/store/products/images/srpski-viteski-kod-marko-aleksic-656085de3c809.webp", 368),
        MyDataItem(7000, "Ilustrovana istorija Srba", "https://www.serbianshop.com/uploads/store/products/images/ilustrovana-istorija-srba-vladimir-corovic-6560862792762.webp", 473)
    )

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        adapter = MyAdapter(context, testData)
    }

    @Test
    fun testGetItemCount() {
        val itemCount = adapter.itemCount
        assertEquals(testData.size, itemCount)
    }
}
