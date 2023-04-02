package com.example.appdoctruyen62TH4byNhom6.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class databasedoctruyen extends SQLiteOpenHelper {
    //Co so du lieu
    private static String DATABASE_NAME = "doctruyen";
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private static int VERSION = 1;

    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";


    private Context context;

    private String SQLQuery = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_TAI_KHOAN+" TEXT UNIQUE, "
            +MAT_KHAU+" TEXT, "
            +EMAIL+" TEXT, "
            + PHAN_QUYEN+" INTEGER) ";

    private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
            +TEN_TRUYEN+" TEXT UNIQUE, "
            +NOI_DUNG+" TEXT, "
            +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";

    private String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'admin','admin','admin@gmail.com',2)";
    private String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'minh','123','khuatquangminhvtp@gmail.com',1)";

    private String SQLQuery4 = "INSERT INTO truyen VALUES (null,'Cóc kiện trời','Ngày xửa ngày xưa, vào một năm không nhớ rõ năm nào, trời làm hạn hán khủng khiếp, nắng lửa hết tháng này đến tháng khác thiêu cháy cây cối, hút cạn nước sông ngòi, đầm hồ. Muôn loài không còn một giọt nước để uống. Các con vật to lớn hùng mạnh xưa nay tác oai tác quái trong rừng đều nằm lè lưỡi mà thở để đợi chết, không ai nghĩ được kế gì để cứu mình, cứu muôn loài. Sức mạnh của chúng chỉ để bắt nạt nhau thôi chứ đâu có thể làm gì nổi ông trời. Duy có anh chàng Cóc tía bé nhỏ, xấu xí kia là có gan to. Anh tính chuyện lên thiên đình kiện Trời làm mưa cứu muôn loài.\n" +
            "\n" +
            "Khởi đầu chỉ có một mình nhưng anh không nản. Ði qua một vũng đầm khô, Cóc tía gặp Cua càng. Cua hỏi Cóc đi đâu, Cóc bèn kể rõ sự tình và rủ Cua cùng đi kiện Trời. Ban đầu Cua định bàn ngang, thà chết ở đây còn hơn chứ Trời xa thế đi sao tới mà kiện với tụng, nhưng những con vật ở quanh Cua nghe Cóc nói lại tranh nhau mà bàn ngang bàn lùi, làm cho Cua nổi giận. Nói ngang bàn ngang là chuyện của Cua thế mà họ lại dám tranh mất cái quyền ấy, cái quyền được phép ngang như cua cơ mà. Thế là Cua làm ngược lại, Cua tình nguyện cùng đi với Cóc.\n" +
            "\n" +
            "Ði được một đoạn nữa, Cóc lại gặp Cọp đang nằm phơi bụng thở thoi thóp, Gấu đang chảy mỡ ròng ròng và khát cháy họng. Cóc rủ Gấu và Cọp đi kiện trời, Cọp còn lưỡng lự thì Gấu đã gạt đi mà nói rằng:\n" +
            "\n" +
            "- Anh Cóc nói có lý, chẳng có lẽ chúng mình cứ nằm ở đây đợi chết khát cả ư? Ta theo anh Cóc thôi! Ðến ngang như anh Cua còn theo anh Cóc được thì tại sao chúng mình không theo.\n" +
            "\n" +
            "Cả bọn nhập lại thành đoàn. Ði thêm một chặng nữa thì gặp đàn Ong đang khô mật và con Cáo bị lửa nướng cháy xém lông. Cả hai con vật này cũng hăng hái nhập vào đoàn loài vật đi kiện Trời do Cóc dẫn đầu.\n" +
            "\n" +
            "Cóc dẫn các bạn đi mãi, đi mãi đến tận cửa thiên đình. Khi đi trên đường cả bọn đều hăng hái nhưng đến trước cửa Trời oai nghiêm, bọn Cọp, Gấu, Cáo, Ong, Cua đều sợ, duy chỉ có Cóc là gan liền dõng dạc ra lệnh:\n" +
            "\n" +
            "- Bây giờ các anh phải nghe lời tôi. Kia là chum nước của Trời, anh Cua vào nấp trong ấy. Anh Cáo nấp ở phía bên trái tôi, anh Gấu nằm ở phía bên phải tôi, còn anh Cọp chịu khó nằm đằng sau tôi. Các anh có nghe lệnh của tôi thì mới thắng được Trời.\n" +
            "\n" +
            "Tất cả đều nghe lệnh của Cóc. Sắp đặt xong đâu đấy Cóc mới nhảy lên mặt trống trờ đánh ba hồi trống ầm vang như sấm động.\n" +
            "\n" +
            "Ngọc Hoàng liền sai Thiên lôi ra xem có chuyện gì. Thiên lôi ngạc nhiên vì ở ngoài cửa thiên đình chẳng thấy có một người nào cả chỉ thấy mỗi một con Cóc xù xì xấu xí đang ngồi chễm trệ trên mặt trống của nhà Trời. Thiên lôi bèn vào tâu Ngọc hoàng, Ngọc hoàng nghe xong bực lắm bèn sai con gà trời bay ra mổ chết chú Cóc hỗn xược kia.\n" +
            "\n" +
            "Gà trời vừa hung hăng bay ra thì Cóc đã nghiến răng ra hiệu, lập tức chàng Cáo nhảy ra cắn cổ gà tha đi mất. Cóc lại đánh trống lôi đình. Ngọc hoàng càng giận giữ sai Chó nhà trời xổ ra cắn Cáo. Chó vừa xồng xộc chạy ra thì Cóc lại nghiến răng ra hiệu. Lập tức anh Gấu lừng lững xổ ra đón đường tát cho chó một đòn trời giáng. Chó chết tươi.\n" +
            "\n" +
            "Cóc lại thúc trống lôi đình đánh thức Ngọc hoàng. Ngọc hoàng bèn sai Thiên lôi ra trị tội gấu. Thiên lôi là vị thần trời có lưỡi tầm sét mỗi lần vung lên thì thành sét đánh ngang trời, thành sấm động bốn cõi. Sức mạnh của Thiên lôi không có ai bì được. Ngọc hoàng yên trí lần này cử đến ông Thiên lôi ra quân thì cái đám Cóc, Cáo ắt hẳn là tan xác.Thiên lôi vừa hùng hổ vác búa tầm sét ra đến cửa thiên đình thì Cóc đã nghiến răng ra lệnh, lập tức đàn Ong nấp trên cánh cửa bay vù ra và cứ nhè vào mũi Thiên lôi mà đốt. Nọc ong đốt đau lắm, mũi Thiên lôi rát như phải bỏng. Nhớ là ở cửa trời có một chum nước. Thiên lôi vội vàng vứt cả búa tầm sét nhảy ùm vào chum nước chạy trốn. Nào ngờ vừa nhảy ùm vào trong chum nước thì anh Cua càng nấp trong đó từ bao giờ đã chờ sẵn để giương đôi càng như đôi gọng kìm cắp chặt lấy cổ. Thiên lôi đau quá gào thét vùng vẫy vỡ cả chum nước nhà Trời. Thiên lôi tìm đường chạy trốn thì Cóc tía lại nghiến răng ra lệnh. Lập tức Cọp nấp sau Cóc tía nhảy bổ ra gầm lên một tiếng vang động xé tan xác Thiên lôi thành hai mảnh." +
            "Ngọc hoàng thấy thế bèn xin giảng hoà với Cóc, và hỏi Cóc lên tận thiên đình có việc gì. Cóc dõng dạc thưa:" +
            "- Ðã bốn năm nay ở dưới trần gian hạn hán kéo dài, không một giọt mưa. Muôn cây khô héo, vạn vật chết khát. Xin Ngọc hoàng làm mưa ngay để cứu muôn loài.\n" +
            "\n" +
            "Ngọc Hoàng sợ trần gian nổi loạn, dịu giọng nói:\n" +
            "\n" +
            "- Thôi, cậu hãy về đi. Ta sẽ cho mưa xuống!\n" +
            "\n" +
            "Lại còn dặn thêm:\n" +
            "\n" +
            "- Lần sau, hễ muốn mưa, cậu chỉ cần nghiến răng báo hiệu cho ta, không cần phải lên đây!\n" +
            "\n" +
            "Khi cóc về đến trần gian thì nước đã ngập cả ruộng đồng. Từ đó, hễ cóc nghiến răng là trời lại đổ mưa. Trong dân gian còn lưu truyền một câu đồng dao rằng:\n" +
            "\n" +
            "Con cóc là cậu ông trời\n" +
            "\n" +
            "Hễ ai đánh nó thì trời đánh cho...','https://cotich.net/uploads/news/a_232510450_coc-kien-troi.jpeg',1)";
    private String SQLQuery5 = "INSERT INTO truyen VALUES (null,'Truyện cổ tích Tấm Cám','Ngày xửa ngày xưa, có hai chị em cùng cha khác mẹ, chị tên là Tấm, em tên là Cám. Mẹ Tấm mất sớm, sau đó mấy năm cha Tấm cũng qua đời, Tấm ở với dì ghẻ là mẹ Cám. Bà mẹ kế này rất cay nghiệt, bắt Tấm phải làm hết mọi việc nặng nhọc từ việc nhà đến việc chăn trâu cắt cỏ. Trong khi đó Cám được nuông chiều không phải làm gì cả.\n" +
            "\n" +
            "Một hôm bà ta cho hai chị em mỗi người một cái giỏ bảo ra đồng xúc tép, còn hứa:\n" +
            "\n" +
            "- Hễ đứa nào bắt được đầy giỏ thì thưởng cho một cái yếm đỏ.\n" +
            "\n" +
            "Ra đồng, Tấm chăm chỉ bắt được đầy giỏ, còn Cám thì mải chơi nên chẳng bắt được gì.\n" +
            "\n" +
            "Thấy Tấm bắt được một giỏ đầy, Cám bảo chị :\n" +
            "\n" +
            "- Chị Tấm ơi, chị Tấm! Đầu chị lấm, chị hụp cho sâu, kẻo về mẹ mắng.\n" +
            "\n" +
            "Tin là thật, Tấm bèn xuống ao lội ra chỗ sâu tắm rửa. Cám thừa dịp trút hết tép của Tấm vào giỏ của mình rồi ba chân bốn cẳng về trước. Lúc Tấm bước lên chỉ còn giỏ không, bèn ngồi xuống bưng mặt khóc hu hu. Nghe tiếng khóc của Tấm, Bụt liền hiện lên hỏi :\n" +
            "\n" +
            "- Làm sao con khóc ?\n" +
            "\n" +
            "Tấm kể lể sự tình cho Bụt nghe, Bụt bảo:\n" +
            "\n" +
            "- Thôi con hãy nín đi ! Con thử nhìn vào giỏ xem còn có gì nữa không?\n" +
            "\n" +
            "Tấm nhìn vào giỏ rồi nói :  \n" +
            "\n" +
            "- Chỉ còn một con cá bống.\n" +
            "\n" +
            "- Con đem con cá bống ấy về thả xuống giếng mà nuôi. Mỗi bữa, đáng ăn ba bát thì con ăn hai còn một đem thả xuống cho bống. Mỗi lần cho ăn con nhớ gọi như thế này:   \n" +
            "\n" +
            "Bống bống bang bang \n" +
            "\n" +
            "Lên ăn cơm vàng cơm bạc nhà ta\n" +
            "\n" +
            "Chớ ăn cơm hẩm cháo hoa nhà người.\n" +
            "\n" +
            "Không gọi đúng như thế thì nó không lên, con nhớ lấy !\n" +
            "\n" +
            "Nói xong Bụt biến mất. Tấm theo lời Bụt thả bống xuống giếng. Rồi từ hôm ấy trở đi, cứ mỗi bữa ăn, Tấm đều để dành cơm, giấu đưa ra cho bống. Mỗi lần nghe Tấm gọi, bống lại ngoi lên mặt nước đớp những hạt cơm của Tấm ném xuống. Người và cá ngày một quen nhau, và bống ngày càng lớn lên trông thấy.\n" +
            "\n" +
            "Thấy Tấm sau mỗi bữa ăn thường mang cơm ra giếng, mụ dì ghẻ sinh nghi, bèn bảo Cám đi rình. Cám nấp ở bụi cây bên bờ giếng nghe Tấm gọi bống, bèn nhẩm lấy cho thuộc rồi về kể lại cho mẹ nghe. Tối hôm ấy mụ dì ghẻ lấy giọng ngọt ngào bảo với Tấm: \n" +
            "\n" +
            "- Con ơi con! Làng đã bắt đầu cấm đồng rồi đấy. Mai con đi chăn trâu, phải chăn đồng xa, chớ chăn đồng nhà, làng bắt mất trâu.\n" +
            "\n" +
            "Tấm vâng lời, sáng hôm sau đưa trâu đi ăn thật xa. Ở nhà, mẹ con Cám mang bát cơm ra giếng cũng gọi bống lên ăn y như Tấm gọi. Nghe lời gọi, bống ngoi lên mặt nước. Mẹ Cám đã chực sẵn, bắt lấy bống đem về nhà làm thịt.\n" +
            "\n" +
            "Đến chiều Tấm dắt trâu về, sau khi ăn xong Tấm lại mang bát cơm để dành ra giếng, Tấm gọi nhưng chả thấy bống ngoi lên như mọi khi. Tấm gọi mãi, gọi mãi, cuối cùng chỉ thấy cục máu nổi lên mặt nước. Biết là có sự chẳng lành cho bống, Tấm òa lên khóc. Bụt lại hiện lên hỏi: \n" +
            "\n" +
            "- Con làm sao lại khóc ?\n" +
            "\n" +
            "Tấm kể sự tình cho Bụt nghe, Bụt bảo:\n" +
            "\n" +
            "- Con bống của con, người ta đã ăn thịt mất rồi. Thôi con hãy nín đi ! Rồi về nhặt xương nó, kiếm bốn cái lọ bỏ vào, đem chôn xuống dưới bốn chân giường con nằm.\n" +
            "\n" +
            "Tấm trở về theo lời Bụt đi tìm xương bống, nhưng tìm mãi các xó vườn góc sân mà không thấy đâu cả. Một con gà thấy thế, bảo Tấm :\n" +
            "\n" +
            "- Cục ta cục tác ! Cho ta nắm thóc, ta bưới xương cho !\n" +
            "\n" +
            "Tấm bốc nắm thóc ném cho gà. Gà chạy vào bếp bới một lúc thì thấy xương ngay. Tấm bèn nhặt lấy bỏ vào lọ và đem chôn dưới chân giường như lời bụt dặn.\n" +
            "\n" +
            " \n" +
            "\n" +
            "Ít lâu sau nhà vua mở hội trong mấy đêm ngày. Già trẻ gái trai các làng đều nô nức đi xem, trên các nẻo đường, quần áo mớ ba mớ bẩy dập dìu tuôn về kinh như nước chảy. Hai mẹ con Cám cũng sắm sửa quần áo đẹp để đi trẩy hội. Thấy Tấm cũng muốn đi, mụ dì ghẻ nguýt dài, sau đó mụ lấy một đấu gạo trộn lẫn với một đấu thóc, bảo Tấm: \n" +
            "\n" +
            "- Khi nào nhặt riêng gạo và thóc ra hai đấu thì mới được đi xem hội. \n" +
            "\n" +
            "Nói đoạn, hai mẹ con quần áo xúng xính lên đường. Tấm tủi thân òa lên khóc. Bụt lại hiện lên hỏi:\n" +
            "\n" +
            "- Làm sao con khóc?\n" +
            "\n" +
            "Tấm chỉ vào cái thúng, thưa:\n" +
            "\n" +
            "- Dì con bắt phải nhặt thóc ra thóc, gạo ra gạo, rồi mới được đi xem hội, lúc nhặt xong thì hội đã tan rồi còn gì mà xem.\n" +
            "\n" +
            "Bụt bảo:\n" +
            "\n" +
            "- Con đừng khóc nữa. Con mang cái thúng đặt ra giữa sân, để ta sai chim sẻ xuống nhặt giúp. \n" +
            "\n" +
            "- Nhưng ngộ nhỡ chim sẻ ăn mất thì khi về con vẫn cứ bị đòn.\n" +
            "\n" +
            "- Con cứ bảo chúng nó thế này:\n" +
            "Rặt rặt (con chim sẻ) xuống nhặt cho tao\n" +
            "\n" +
            "Ăn mất hạt nào thì tao đánh chết\n" +
            "\n" +
            "Thì chúng nó sẽ không ăn của con đâu.\n" +
            "\n" +
            "Bụt vừa dứt lời, ở trên không có một đàn chim sẻ đáp xuống sân nhặt thóc ra một đằng, gạo ra một nẻo. Chúng nó lăng xăng ríu rít chỉ trong một lát đã làm xong, không suy suyển một hạt. Nhưng khi chim sẻ bay đi rồi, Tấm lại nức nở khóc. Bụt lại bảo: \n" +
            "\n" +
            "- Con làm sao lại khóc?\n" +
            "\n" +
            "- Con rách rưới quá, người ta không cho con vào xem hội.\n" +
            "\n" +
            "- Con hãy đào những cái lọ xương bống đã chôn ngày trước lên thì sẽ có đủ thứ cho con trẩy hội.\n" +
            "\n" +
            "Tấm vâng lời, đi đào các lọ lên. Đào lọ thứ nhất lấy ra được một cái áo mớ ba, một cái áo xống lụa, một cái yếm lụa điều và một cái khăn nhiễu. Đào lọ thứ hai lấy ra được một đôi hài thêu. Đào lọ thứ ba thì thấy một con ngựa bé tí, nhưng vừa đặt con ngựa xuông đất bỗng chốc nó đã hí vang lên và biến thành ngựa thật. Đào đến lọ cuối cùng thì lấy ra được một bộ yên cương xinh xắn.\n" +
            "\n" +
            "Tấm mừng quá vội tắm rửa rồi thắng bộ vào, đoạn cưỡi lên ngựa mà đi. Ngựa phóng một chốc đã đến kinh đô. Nhưng khi phóng qua một cây cầu đá, Tấm đánh rơi một chiếc hài xuống nước, không cách nào mò lên được. \n" +
            "\n" +
            "Khi đoàn xa giá chở vua đi qua cầu, con voi ngự bỗng nhiên cắm ngà xuống đất kêu rống lên, không chịu đi. Vua sai quân lính xuống nước thử tìm xem, họ mò được một chiếc hài thêu rất tinh xảo và xinh đẹp. Vua ngắm nghía chiếc hài hồi lâu rồi hạ lệnh cho rao mời tất cả đám đàn bà con gái xem hội ướm thử, hễ ai đi vừa chiếc giầy thì vua sẽ lấy làm vợ.\n" +
            "\n" +
            "Đám hội lại càng náo nhiệt vì các bà, các cô chen nhau đến chỗ thử giầy. Cô nào cô ấy lần lượt kéo vào ngôi lầu giữa bãi cỏ rộng để ướm một tí cầu may. Nhưng chẳng có một chân nào đi vừa cả. Mẹ con Cám cũng trong số đó. Khi Cám và dì ghẻ bước ra khỏi lầu thì gặp Tấm, Cám mách mẹ:\n" +
            "\n" +
            "- Mẹ ơi, ai như chị Tấm cũng đi thử hài đấy!\n" +
            "\n" +
            "Mụ dì ghẻ bĩu môi:\n" +
            "\n" +
            "- Chuông khánh còn chẳng ăn ai, nữa là mảnh chĩnh vứt ngoài bờ tre!\n" +
            "\n" +
            "Nhưng khi Tấm đặt chân vào hài thì vừa như in. Nàng mở khăn lấy luôn chiếc thứ hai đi vào. Hai chiếc hài giống nhau như đúc. Bọn lính hầu hò reo vui mừng. Lập tức vua sai đoàn tỳ nữ rước nàng vào cung. Tấm bước lên kiệu trước con mắt ngạc nhiên và hằn học của mẹ con Cám.\n" +
            "\n" +
            " \n" +
            "\n" +
            "Tuy sống sung sướng trong hoàng cung. Tấm vẫn không quên ngày giỗ cha. Nàng xin phép vua trở về nhà để soạn cỗ cúng giúp dì. Mẹ con Cám thấy Tấm sung sướng thì ghen ghét để bụng. Nay thấy Tấm về, lòng ghen ghét lại bùng bốc lên. Nghĩ ra được một mưu, mụ dì ghẻ bảo Tấm:\n" +
            "\n" +
            "- Trước đây con quen trèo cau, con hãy trèo lên xé lấy một buồng cau để cúng bố. \n" +
            "\n" +
            "Tấm vâng lời trèo lên cây cau, lúc lên đến sát buồng thì ở dưới này mụ dì ghẻ cầm dao đẵn gốc. Thấy cây rung chuyển, Tấm hỏi :\n" +
            "\n" +
            "- Dì làm gì dưới gốc thế ?\n" +
            "\n" +
            "- Gốc cau lắm kiến, dì đuổi kiến cho nó khỏi lên đốt con.\n" +
            "\n" +
            "Nhưng Tấm chưa kịp xé cau thì cây cau đã đổ. Tấm ngã lộn cổ xuống ao chết. Mụ dì ghẻ vội vàng lột áo quần của Tấm cho con mình mặc vào cung nói dối với vua rằng Tấm không may bị rơi xuống ao chết đuối, nay đưa em vào để thế chị. Vua nghe nói trong bụng không vui, nhưng không biết phải làm thế nào cả.\n" +
            "\n" +
            " \n" +
            "\n" +
            "Lại nói chuyện Tấm chết hóa thành chim Vàng anh, chim bay một mạch về kinh đến vườn ngự. Thấy Cám đang giặt áo cho vua ở giếng, Vàng anh dừng lại trên cành cây, bảo nó:\n" +
            "\n" +
            "- Phơi áo chồng tao, phơi lao phơi sào, chớ phơi bờ rào, rách áo chồng tao.\n" +
            "\n" +
            "Rồi chim Vàng anh bay thẳng vào cung rồi đậu ở cửa sổ, hót lên rất vui tai. Vua đi đâu, chim bay đến đó. Vua đang nhớ Tấm không nguôi, thấy chim quyến luyến theo mình, vua bảo:\n" +
            "\n" +
            "- Vàng ảnh vàng anh, có phải vợ anh, chui vào tay áo.\n" +
            "\n" +
            "Chim vàng anh bay lại đậu vào tay vua rồi rúc vào tay áo. Vua yêu quý vàng anh quên cả ăn ngủ. Vua sai làm một cái lồng bằng vàng cho chim ở. Từ đó, ngày đêm vua chỉ mải mê với chim, không tưởng đến Cám. \n" +
            "\n" +
            "Cám vội về mách mẹ. Mẹ nó bảo cứ bắt chim làm thịt ăn rồi kiếm điều nói dối vua. Trở lại cung vua, nhân lúc vua đi vắng, Cám bắt chim làm thịt nấu ăn rồi vứt lông chim ở ngoài vườn.\n" +
            "\n" +
            " \n" +
            "\n" +
            "Lông chim vàng anh chôn ở vườn hoá ra hai cây xoan đào. Khi vua đi chơi vườn ngự, cành lá của chúng sà xuống che kín thành bóng, như hai cái lọng. Vua thấy cây đẹp rợp bóng, sai lính hầu mắc vọng vào hai cây rồi nằm chơi hóng mát. Khi vua đi khỏi thì cành cây lại vươn thẳng trở lại. Từ đó, không ngày nào Vua không ra nằm hóng mát ở hai cây xoan đào.\n" +
            "\n" +
            "Cám biết chuyện ấy lại về nhà mách mẹ. Mẹ nó bảo, cứ sai thợ chặt cây làm khung cửi rồi kiếm điều nói dối vua. Về đến cung, nhân một hôm gió bão, Cám sai thợ chặt cây xoan đào lấy gỗ đóng khung cửi. Thấy cây bị chặt, vua hỏi thì Cám đáp:\n" +
            "\n" +
            "- Cây bị đổ vì bão, thiếp sai thợ chặt làm khung cửi để dệt áo cho bệ hạ.\n" +
            "\n" +
            "Nhưng khi khung cửi đóng xong. Cám ngồi vào dệt lúc nào cũng nghe thấy tiếng khung cửi rủa mình :\n" +
            "\n" +
            "   Cót ca cót két\n" +
            "\n" +
            "   Lấy tranh chồng chị.\n" +
            "\n" +
            "   Chị khoét mắt ra\n" +
            "\n" +
            "Thấy vậy Cám sợ hãi, vội về nhà mách mẹ. Mẹ nó bảo đốt quách khung cửi, rồi đem tro đi đổ cho rõ xa để được yên tâm. Về đến cung, Cám làm như lời mẹ nói. Nó đem tro đã đốt đi đổ ở lề đường cách xa hoàng cung.\n" +
            "\n" +
            " \n" +
            "\n" +
            "Đống tro bên đường lại mọc lên một cây thị cao lớn, cành lá xum xuê. Đến mùa có quả, cây thị chỉ đậu được có một quả, nhưng mùi thơm ngát tỏa ra khắp nơi. Một bà lão hàng nước gần đó có một hôm đi qua dưới gốc, ngửi thấy mùi thơm, ngẩng đầu nhìn lên thấy quả thị trên cành cao, bèn giơ bị ra nói lẩm bẩm: \n" +
            "\n" +
            "- Thị ơi thị à, rụng vào bị bà, bà để bà ngửi chứ bà không ăn. \n" +
            "\n" +
            "Bà lão nói vừa dứt lời, thì quả thị rụng ngay xuống đúng vào bị. Bà lão nâng niu đem về nhà cất trong buồng, thỉng thoảng lại vào ngắm nghía và ngửi mùi thơm.\n" +
            "\n" +
            "Ngày nào bà lão cũng đi chợ vắng. Từ trong quả thị chui ra một cô gái thân hình bé nhỏ như ngón tay, nhưng chỉ trong chớp mắt đã biến thành Tấm. Tấm vừa bước ra đã cầm lấy chổi quét dọn nhà cửa sạch sẽ, rồi đi vo gạo thổi cơm, hái rau ở vườn nấu canh giúp bà hàng nước. Đoạn Tấm lại thu hình bé nhỏ như cũ rồi chui vào quả thị. Lần nào đi chợ về, bà lão cũng thấy nhà cửa ngăn nắp, cơm ngon, canh ngọt sẵn sàng, thì lấy làm lạ.\n" +
            "\n" +
            "Một hôm bà hàng nước giả vờ đi chợ, đến nửa đường lại lén trở về, rình ở bụi cây sau nhà. Trong khi đó, Tấm từ quả thị chui ra rồi cũng làm việc như mọi lần. Bà lão rón rén lại nhìn vào khe cửa. Khi thấy cô gái xinh đẹp thì bà mừng quá, bất thình lình xô cửa vào ôm choàng lấy Tấm, đoạn xé vụn vỏ thị.\n" +
            "\n" +
            "Từ đó Tấm ở với bà hàng nước, hai người thương nhau như hai mẹ con. Hàng ngày Tấm giúp bà lão các việc thổi cơm, nấu nước, gói bánh, têm trầu để cho bà bán hàng.\n" +
            "\n" +
            "Một hôm vua đi chơi ra khỏi hoàng cung, Thấy có quán nước bên đường sạch sẽ, bèn ghé vào. Bà lão mang trầu nước dâng lên vua. Thấy trầu têm cánh phượng, vua sực nhớ tới trầu vợ mình têm ngày trước cũng y như vậy, liền hỏi :\n" +
            "\n" +
            "- Trầu này ai têm?\n" +
            "\n" +
            "- Trầu này con gái lão têm - bà lão đáp.\n" +
            "\n" +
            "- Con gái của bà đâu, gọi ra đây cho ta xem mặt.\n" +
            "\n" +
            "Bà lão gọi Tấm ra. Tấm vừa xuất hiện, vua nhận ra ngay vợ mình ngày trước, có phần trẻ đẹp hơn xưa. Vua mừng quá, bảo bà lão hàng nước kể lại sự tình, rồi truyền cho quân hầu đưa kiệu rước Tấm về cung.\n" +
            "\n" +
            " \n" +
            "\n" +
            "Cám Thấy Tấm trở về và được vua yêu thương như xưa, thì không khỏi ghen tỵ. Một hôm, Cám hỏi chị :\n" +
            "\n" +
            "- Chị Tấm ơi, chị Tấm! Chị làm thế nào mà đẹp thế ?\n" +
            "\n" +
            "Tấm không đáp, chỉ hỏi lại:\n" +
            "\n" +
            "- Có muốn đẹp không để chị giúp !\n" +
            "\n" +
            "Cám bằng lòng ngay. Tấm sai quân hầu đào một cái hố sâu và đun một nồi nước sôi. Tấm bảo Cám xuống hố rồi sai quân hầu dội nước sôi vào hố. Cám chết. Tấm sai đem xác làm mắm bỏ vào chĩnh gửi cho mụ dì ghẻ, nói là quà của con gái mụ gửi biếu. Mẹ Cám tưởng thật, lấy mắm ra ăn, bữa nào cũng nức nở khen ngon. Một con quạ ở đâu bay đến đậu trên nóc nhà kêu rằng:\n" +
            "\n" +
            "- Ngon ngỏn ngòn ngon ! Mẹ ăn thịt con, có còn xin miếng.\n" +
            "\n" +
            "Mẹ Cám giận lắm, chửi mắng ầm ĩ rồi vác sào đuổi quạ. Nhưng đến ngày ăn gần hết, dòm vào chĩnh, mụ thấy đầu lâu của con thì kinh hoàng lăn đùng ra chết...." +
            "Ý nghĩa rút ra:\n" +
            "\n" +
            "Câu chuyện cổ tích của mẹ kế và người em độc ác muốn nhắn nhủ đến các em rằng. Trong cuộc sống, những người ăn ở hiền lành, tốt bụng sẽ được ông trời, thần Phật giúp đỡ và chở che.Còn những ai sống ác, tìm cách hãm hại người khác sớm muộn cũng sẽ nhận phải báo ứng mà mình đã gây ra. Người “Ở hiền ắt sẽ gặp lành” đó là quy luật của cuộc sống.','https://cotich.net/uploads/news/a_454455241_truyen-co-tich-tam-cam.jpeg',1)";
    private String SQLQuery6 = "INSERT INTO truyen VALUES (null,'Cây khế','Một nhà kia có hai anh em, cha mẹ đều chết cả. Hai anh em chăm lo làm lụng, nên trong nhà cũng đủ ăn. Muốn cho vui cửa vui nhà, hai người cùng lấy vợ. Nhưng từ khi có vợ, người anh sinh ra lười biếng, bao nhiêu công việc khó nhọc, đều trút cả cho hai vợ chồng người em.\n" +
            "Hai vợ chồng người em thức khuya dậy sớm, lại cố gắng cày cấy, làm cỏ, bỏ phân, lúa tốt hơn trước, nên đến mùa, được bội thu. Thấy thế, người anh sợ em kể công chiếm lấy phần hơn, vội bàn với vợ cho hai vợ chồng người em ra ở riêng.\n" +
            "\n" +
            "Ra ở riêng với vợ, người em được người anh chia cho có một căn nhà tranh lụp xụp, trước nhà có một cây khế ngọt. Hai vợ chồng người em không phàn nàn một lời, hết vào rừng đốn củi đem ra chợ bán, lại đi gánh mướn, làm thuê.\n" +
            "Còn người anh có bao nhiêu ruộng nương đều cho làm rẽ, để ngồi không hưởng sung sướng với vợ. Thấy em không ca thán, người anh cho em là ngu si, lại càng lên mặt, không lui tới nhà em và cũng không để ý gì đến em nữa.\n" +
            "Những ngày sung sướng nhất của hai vợ chồng người em là những ngày khế chín. Quanh năm, hai vợ chồng đã chăm bón và bắt sâu, đuổi kiến cho cây khế, nên cây khế xanh mơn mởn, bóng rợp khắp mảnh vườn nhỏ bé, quả lúc lỉu cả ở những cành là sát mặt đất, trẻ lên ba cũng với tay được.\n" +
            "\n" +
            "Một buổi sáng, hai vợ chồng mang quang gánh và thúng bị ra gốc khế, định trèo lên hái quả đem ra chợ bán thì thấy trên ngọn cây rung động rất mạnh, như có người đang trèo. Hai vợ chồng nhìn lên thì thấy một con chim rất lớn đang ăn những quả khế chín vàng. Hai vợ chồng đứng dưới gốc cây xem chim ăn, đợi chim bay đi rồi mới trèo lên cây hái quả. Từ đấy, cứ mỗi buổi sáng tinh mơ, hai vợ chồng ra hái khế, thì đã lại thấy chim ở trên cây rồi. Thấy có người, chim vẫn cứ ăn, ung dung một lúc lâu, rồi mới vỗ cánh bay đi. Chim ăn ròng rã như thế ngót một tháng trời, cây khế vợi hẳn quả.\n" +
            "\n" +
            "Một hôm, đứng đợi cho chim ăn xong, người vợ nói nửa bỡn nửa thật với chim: “Chim ơi, chim ăn như thế thì còn gì là khế của nhà tôi nữa! Cây khế nhà tôi cũng sắp hết quả rồi đấy, chim ạ!”. Chim bỗng nghển cổ, nheo mắt như cười, đáp lại: “Ăn một quả, trả cục vàng! May túi ba gang, đem đi mà đựng”. Chim nhắc đi nhắc lại câu ấy ba lần, rồi mới vỗ cánh bay đi.\n" +
            "Hai vợ chồng thấy chim biết nói đã lấy làm lạ, lại thấy chim bảo mình như thế, nhắc lại cho mình đến ba lần, nghe rõ mồn một, nên càng suy nghĩ, phân vân.\n" +
            "Nhưng rồi hai vợ chồng cũng làm theo lời chim. Người vợ lấy vài vuông vải nâu may cho chồng một cái túi, ngang dọc đúng ba gang.\n" +
            "\n" +
            "Sáng hôm sau, hai vợ chồng vừa ăn xong thì thấy một luồng gió mạnh cuốn cả cát bụi trước sân nhà, rồi trong chớp mắt một con chim cực kỳ lớn hạ xuống giữa sân, quay đầu vào nhà kêu lên mấy tiếng như chào hỏi. Người chồng xách cái túi ba gang ra sân, chim nằm rạp xuống, quay cổ ra hiệu cho anh ngồi lên lưng mình. Anh ngồi lên lưng chim, bám vào cổ chim thật chặt. Chim đứng dậy vươn cổ, vỗ cánh bay bổng lên trời xanh. Chim lúc bay cao, lẩn vào mây bạc; lúc bay thấp, là là trên rừng xanh, đồi núi trập trùng. Rồi chim bay ra biển cả mênh mông, sóng biếc cao ngất vật vào sườn những hòn đảo nhỏ, làm tung lên những bọt trắng xóa. Anh ngồi trên lưng chim thấy biển tuyệt mù, không biết đâu là bờ… Thốt nhiên chim bay vào một hòn đảo toàn đá trắng, đá xanh, đá đỏ, đã ngũ sắc, phản chiếu ánh sáng rực rỡ, anh chưa từng thấy bao giờ. Chim bay một vòng thật rộng xung quanh đảo như muốn tìm một nơi hạ cánh, rồi bay những vòng hẹp hơn, là là trên các ngọn đá, lắm lúc anh tưởng như mình sắp bị va vào những tảng đá khổng lồ. Bay đến trước mặt cái hang rộng và sâu, chim từ từ hạ xuống. Ðặt chân xuống đảo, anh nhìn ngó khắp nơi, tuyệt nhiên không thấy một sinh vật nào, không có đến một ngọn cỏ hay một mống chim sâu.\n" +
            "\n" +
            "Chim ra hiệu bảo anh vào hang, muốn lấy gì thì lấy. Ở ngay cửa hang, anh đã thấy toàn những thứ đá trong như thủy tinh và hổ phách đủ các mầu; có thứ xanh như mắt mèo, có thứ đỏ ối như mặt trời, còn vàng bạc thì nhiều như sỏi đá. Thấy hang sâu và rộng, anh không dám vào sợ lạc. Anh nhặt một ít vàng và kim cương bỏ vào túi ba gang, rồi trèo lên lưng chim, ra hiệu cho chim bay về.\n" +
            "\n" +
            "Chim tỏ vẻ vui mừng, gật gật cái đầu, vươn cổ kêu vài tiếng, rồi vỗ cánh bay lên trời xanh, bay qua biển, qua rừng, qua núi. Mặt trời mới vừa đứng bóng, chim đã hạ cánh xuống cái vườn nhỏ có cây khế ngọt. Người vợ thấy chồng về bình yên, mừng rỡ vô cùng, chạy ra vuốt lông chim, tỏ ý cảm ơn, ra hiệu mời chim bay lên cây khế giải khát. Chim bay lên cây khế ăn một lúc, rồi kêu ba tiếng như chào vợ chồng người nông dân, rồi bay đi. Từ đấy, lâu lâu chim mới lại đến ăn khế.\n" +
            "\n" +
            "Tiếng đồn hai vợ chồng người em thốt nhiên giàu có bay đến tai hai vợ chồng người anh. Hai vợ chồng người anh vội vã đến chơi nhà em để dò xét. Nghe em thật thà kể chuyện, người anh gạ đổi hết tài sản của mình để lấy túp lều tranh và cây khế. Hai vợ chồng chỉ lo người em không chịu đổi, không ngờ người em vui vẻ ưng thuận ngay.\n" +
            "\n" +
            "Hai vợ chồng người anh mừng rỡ như mở cờ trong bụng, lập tức giao hết tài sản của mình cho em, và sáng hôm sau dọn ngay đến ở túp lều tranh trên mảnh vườn nhỏ có cây khế ngọt. đến ở mảnh vườn chật hẹp, hai vợ chồng người anh không làm việc gì cả. Còn được ít tiền hai vợ chồng đem tiêu dần, cả ngày chỉ nằm khểnh ngoài hè, hí hửng nhìn lên cây khế, chờ chim bay đến. Một buổi sáng, có một luồng gió mạnh tạt vào nhà, rồi hai vợ chồng thấy ngọn cây khế rung chuyển. Hai người hớt hải chạy ra sân, vội nhìn lên cây thì quả nhiên thấy một con chim lớn đang ăn khế.\n" +
            "\n" +
            "Chim mới ăn vài quả, hai vợ chồng đã tru tréo lên: “Cả nhà chúng tôi trông vào có cây khế, bây giờ chim ăn tào ăn huyệt như thế thì chúng tôi còn trông cậy vào đâu!”. Chim liền đáp: “Ăn một quả, trả cục vàng. May túi ba gang, đem đi mà đựng”; rồi chim bay vụt đi.\n" +
            "Hai vợ chồng người anh mừng quá, cuống quýt vái theo chim, rồi bàn nhau may túi, cãi cọ om sòm. Mới đầu, hai người định may thật nhiều túi, sau lại sợ chim không đưa đi, nên rút cục cũng chỉ may một cái túi như người em, nhưng may to gấp ba, mỗi chiều chín gang, thành một cái tay nải lớn.\n" +
            "\n" +
            "Sáng hôm sau, chim hạ cánh xuống sân trước túp lều tranh. Người anh đang ăn, thấy chim bay đến, bỏ cả ăn hấp tấp chạy ra, tay xách cái túi lớn trèo tót lên lưng chim, còn người vợ vái lấy vái để chim thần. Chim cất cánh bay bổng lên mây xanh, qua núi qua biển cả, rồi cũng hạ cánh xuống cái đảo khi trước.\n" +
            "\n" +
            "Trên lưng chim bước xuống, người anh hoa cả mắt về những ánh ngũ sắc ở các loại kim cương và ngọc quý chiếu ra. Ðến khi vào hang, người anh lại càng mê mẩn tâm thần, quên cả đói cả khát, cố nhặt vàng và kim cương cho thật đầy tay nải, lại buộc đầu ống quần và tay áo cho thật chặt rồi nhồi nhét đầy cả hai tay áo và hai ống quần, đến nỗi nặng quá, chàng ta cố kéo lê từng bước mà vẫn chưa ra được khỏi hang.\n" +
            "\n" +
            "Chim đợi lâu quá, chốc chốc lại kêu lên vài tiếng vang cả đảo, thúc giục anh chàng ra về. Mãi gần chiều, anh ta mới kéo được cái tay nải đầy vàng và kim cương đến chỗ chim đang đợi. Muốn cho khỏi rơi, anh ta đặt tay nải dưới cánh chim, rồi lấy dây thừng buộc chặt tay nải vào lưng chim và vào cổ mình.\n" +
            "\n" +
            "Chim vỗ cánh bay lên, nhưng vì nặng quá, mới bay lên khỏi mặt đất một ít lại sa xuống. Sau chim cố gắng đạp hai chân thật mạnh xuống đất, vươn cổ bay bổng lên. Anh chàng ngồi trên lưng chim khấp khởi mừng thầm, cho là chỉ trong giây phút mình sẽ về đến nhà, sẽ có nhà cao cửa rộng, vườn ruộng khắp nơi, tiêu pha hết đời thật hoang toàng cũng không hết của.\n" +
            "Lúc ấy, chim đã bay trên biển cả. Trời trở gió, những con sóng xám xì cất cao lên bằng mấy nóc nhà. Chim bay ngược gió rất là nhọc mệt, cổ gập hẳn xuống, hai cánh mỗi lúc một yếu dần. Túi vàng lớn thốt nhiên bị gió hất mạnh vào cánh chim. Chim buông xuôi hai cánh, đâm bổ từ lưng trời xuống biển. Chỉ trong chớp mắt, người anh bị sóng cuốn đi, cái túi lớn và những ống quần, tay áo chứa đầy vàng và châu báu dìm anh ta rất mau xuống đáy biển.\n" +
            "Còn chim chỉ bị ướt lông, ướt cánh một lúc, rồi chim lại vùng lên khỏi mặt nước, bay về núi, về rừng." +
            "Ý nghĩa rút ra\n" +
            "\n" +
            "Ở đời không nên sống tham lam, ích kỷ nếu không sẽ phải trả cái giá thật đắt như cái kết của người anh trong truyện. Đồng thời, khuyên con người chúng ta hãy luôn làm việc siêng năng, chăm chỉ sẽ gặt hái được quả ngọt. “Trời không phụ lòng người”.','https://truyencotich.vn/wp-content/uploads/2012/10/11284_full-660x440.jpg',1)";
    private String SQLQuery7 = "INSERT INTO truyen VALUES (null,'Sọ Dừa','Ngày xưa, có hai vợ chồng một lão nông nghèo đi ở cho nhà một phú ông. Họ hiền lành, chăm chỉ nhưng đã ngoài năm mươi tuổi mà chưa có lấy một mụn con.\n" +
            "Một hôm, người vợ vào rừng lấy củi. Trời nắng to, khát nước quá, thấy cái sọ dừa bên gốc cây to đựng đầy nước mưa, bà bèn bưng lên uống. Thế rồi, về nhà, bà có mang.\n" +
            "Ít lâu sau, người chồng mất. Bà sinh ra một đứa con không có chân tay, mình mẩy, cứ tròn lông lốc như một quả dừa. Bà buồn, toan vứt nó đi thì đứa bé lên tiếng bảo.\n" +
            "– Mẹ ơi! Con là người đấy! Mẹ đừng vứt con mà tội nghiệp. Bà lão thương tình để lại nuôi rồi đặt tên cho cậu là Sọ Dừa.\n" +
            "\n" +
            "Lớn lên, Sọ Dừa vẫn thế, cứ lăn lông lốc chẳng làm được việc gì. Bà mẹ lấy làm phiền lòng lắm. Sọ Dừa biết vậy bèn xin mẹ đến chăn bò cho nhà phú ông.\n" +
            "\n" +
            "Nghe nói đến Sọ Dừa, phú ông ngần ngại. Nhưng nghĩ: nuôi nó thì ít tốn cơm, công sá lại chẳng đáng là bao, phú ông đồng ý. Chẳng ngờ cậu chăn bò rất giỏi. Ngày ngày, cậu lăn sau đàn bò ra đồng, tối đến lại lăn sau đàn bò về nhà. Cả đàn bò, con nào con nấy cứ no căng. Phú ông lấy làm mừng lắm!\n" +
            "\n" +
            "Vào ngày mùa, tôi tớ ra đồng làm hết cả, phú ông bèn sai ba cô con gái thay phiên nhau đem cơm cho Sọ Dừa. Trong những lần như thế, hai cô chị kiêu kì, ác nghiệt thường hắt hủi Sọ Dừa, chỉ có cô em vốn tính thương người là đối đãi với Sọ Dừa tử tế.\n" +
            "\n" +
            "Một hôm đến phiên cô út mang cơm cho Sọ Dừa. Mới đến chân núi, cô bỗng nghe thấy tiếng sáo véo von. Rón rén bước lên cô nhìn thấy một chàng trai khôi ngô tuấn tú đang ngồi trên chiếc võng đào thổi sáo cho đàn bò gặm cỏ. Thế nhưng vừa mới đứng lên, tất cả đã biến mất tăm, chỉ thấy Sọ Dừa nằm lăn lóc ở đấy. Nhiều lần như vậy, cô út biết Sọ Dừa không phải người thường, bèn đem lòng yêu quý.\n" +
            "\n" +
            "Đến cuối mùa ở thuê, Sọ Dừa về nhà giục mẹ đến hỏi con gái phú ông về làm vợ. Bà lão thấy vậy tỏ ra vô cùng sửng sốt, nhưng thấy con năn nỉ mãi, bà cũng chiều lòng.\n" +
            "Thấy mẹ Sọ Dừa mang cau đến dạm, phú ông cười mỉa mai:\n" +
            "– Muốn hỏi con gái ta, hãy về sắm đủ một chĩnh vàng cốm, mười tấm lụa đào, mười con lợn béo, mười vò rượu tăm đem sang đây.\n" +
            "\n" +
            "Bà lão đành ra về, nghĩ là phải thôi hẳn việc lấy vợ cho con. Chẳng ngờ, đúng ngày hẹn, bỗng dưng trong nhà có đầy đủ mọi sính lễ, lại có cả gia nhân ở dưới nhà chạy lên khiêng lễ vật sang nhà của phú ông. Phú ông hoa cả mắt lúng túng gọi ba cô con gái ra hỏi ý. Hai cô chị bĩu môi chê bai Sọ Dừa xấu xí rồi ngúng nguẩy đi vào, chỉ có cô út là cúi đầu e lệ tỏ ý bằng lòng.\n" +
            "\n" +
            "Trong ngày cưới, Sọ Dừa cho bày cỗ thật linh đình, gia nhân chạy ra chạy vào tấp nập. Lúc rước dâu, chẳng ai thấy Sọ Dừa trọc lốc, xấu xí đâu chỉ thấy một chàng trai khôi ngô tuấn tú đứng bên cô út. Mọi người thấy vậy đều cảm thấy sửng sốt và mừng rỡ, còn hai cô chị thì vừa tiếc lại vừa ghen tức.\n" +
            "\n" +
            "Từ ngày ấy, hai vợ chồng Sọ Dừa sống với nhau rất hạnh phúc. Không những thế, Sọ Dừa còn tỏ ra rất thông minh. Chàng ngày đêm miệt mài đèn sách và quả nhiên năm ấy, Sọ Dừa đỗ trạng nguyên. Thế nhưng cũng lại chẳng bao lâu sau, Sọ Dừa được vua sai đi sứ. Trước khi đi, chàng đưa cho vợ một hòn đá lửa, một con dao và hai quả trứng gà nói là để hộ thân.\n" +
            "\n" +
            "Ganh tị với cô em, hai cô chị sinh lòng ghen ghét rắp tâm hại em để thay làm bà trạng. Nhân quan trạng đi vắng, hai chị sang rủ cô út chèo thuyền ra biển rồi cứ thế lừa đẩy cô em xuống nước. Cô út bị cá kình nuốt chửng, nhưng may có con dao mà thoát chết. Cô dạt vào một hòn đảo, lấy dao khoét bụng cá chui ra, đánh đá lấy lửa nướng thịt cá ăn. Sống được ít ngày trên đảo, hai quả trứng gà cũng kịp nở thành một đôi gà đẹp để làm bạn cùng cô út.\n" +
            "\n" +
            "Một hôm có chiếc thuyền đi qua đảo, con gà trống nhìn thấy bèn gáy to:\n" +
            "ò… ó… o\n" +
            "Phải thuyền quan trạng rước cô tôi về.\n" +
            "Quan cho thuyền vào xem, chẳng ngờ đó chính là vợ mình. Hai vợ chồng gặp nhau, mừng mừng tủi tủi. Đưa vợ về nhà, quan trạng mở tiệc mừng mời bà con đến chia vui, nhưng lại giấu vợ trong nhà không cho ai biết. Hai cô chị thấy thế khấp khởi mừng thầm, tranh nhau kể chuyện cô em rủi ro ra chiều thương tiếc lắm. Quan trạng không nói gì, tiệc xong mới cho gọi vợ ra. Hai cô chị nhìn thấy cô em thì xấu hổ quá, lén bỏ ra về rồi từ đó bỏ đi biệt xứ." +
            "Ý nghĩa rút ra:\n" +
            "\n" +
            "Qua câu chuyện cổ tích Sọ Dừa chúng ta không nên “trông mặt mà bắt hình dong” để đối xử với mọi người xung quanh. Vẻ đẹp tâm hồn vẫn là quan trọng nhất, “tốt gỗ hơn tốt nước sơn”. Đừng bao giờ đánh giá người khác qua vẻ bề ngoài.','https://cdn.tgdd.vn/Files/2022/08/16/1456523/truyen-co-tich-so-dua-loi-ke-va-y-nghia-cau-chuyen-202208160754006533.jpg',1)";
    private String SQLQuery8 = "INSERT INTO truyen VALUES (null,'Vào thời Hùng Vương có một người đàn bà đã nhiều tuổi nhưng sống một mình. Một hôm sáng dậy bà đi thăm nương, bỗng nhìn thấy một vết chân giẫm nát cả mấy luống cà. Bà kêu lên: – “Ôi! Bàn chân ai mà to thế này!”." +
            "Bỗng bà cảm thấy rùng mình khi đưa bàn chân ướm thử vào dấu chân lạ. Và từ đó bà có mang. Đủ ngày tháng, bà sinh được một đứa con trai bụ bẫm đặt tên là Gióng. Nhưng thằng bé đã lên ba tuổi rồi mà vẫn nằm ngửa đòi ăn, không biết ngồi biết lẫy, cũng không biết nói hay biết cười." +
            "Ngày ấy có giặc Ân kéo vào cướp nước ta. Giặc Ân rất hung tàn, cầm đầu là một viên tướng tên gọi Ân vương. Chúng đi đến đâu là đốt phá nhà cửa, giết người cướp của đến đấy. Quân đội Hùng Vương nhiều phen xuất trận, nhưng đánh không nổi lại chúng. Vua Hùng lấy làm lo lắng vội phái sứ giả đi khắp nơi trong nước tìm tướng tài để giúp vua cứu nước.\n" +
            "\n" +
            "Một hôm sứ giả đi đến làng chú bé Gióng. Nghe tiếng loa rao nói đến việc nhà vua cầu người tài, bà mẹ Gióng đang ru con, liền bảo đùa con rằng:\n" +
            "\n" +
            "– Con ơi! Con của mẹ chậm đi chậm nói thì biết bao giờ mới đi đánh giặc giúp vua được đây!\n" +
            "\n" +
            "Không ngờ Gióng nhìn mẹ mở miệng bật lên thành tiếng:\n" +
            "\n" +
            "– Mẹ cho gọi sứ giả vào đây cho con!\n" +
            "\n" +
            "Nói xong lại im bặt. Bà mẹ vừa mừng vừa sợ, vội đi kể chuyện với xóm giềng. Mọi người tới nhà ai nấy cho là một sự lạ. Sau cùng một người nói:\n" +
            "\n" +
            "– Ta cứ đi mời sứ giả đến xem thử nó muốn cái gì.\n" +
            "\n" +
            "Khi sứ giả của nhà vua bước vào nhìn thấy chú bé Gióng liền hỏi rằng:\n" +
            "\n" +
            "– Mày là đứa trẻ lên ba mới học nói, mày định mời ta đến đây để làm gì?\n" +
            "\n" +
            "Gióng trả lời rất chững chạc:\n" +
            "\n" +
            " \n" +
            "– Về bảo với nhà vua rèn cho ta một con ngựa sắt, một thanh gươm sắt, một giáp sắt và một nón sắt, ta sẽ đánh đuổi giặc dữ cho!\n" +
            "\n" +
            "Ai nấy đứng nghe khôn xiết lạ lùng. Cho là thần nhân xuất hiện, sứ giả lập tức phi ngựa về tâu với nhà vua. Nghe nói, Hùng Vương mừng rỡ liền ra lệnh cho thợ rèn góp tất cả sắt lại rèn ngựa, gươm, áo giáp và nón như lời xin của chú bé. Mọi thứ rèn đã xong nặng không thể tưởng tượng nổi. Hàng chục người mó vào thanh gươm mà không nhúc nhích. Vua Hùng phải cho hàng ngàn quân sĩ tìm mọi cách để chở đến cho chú bé Gióng." +
            "Khi được tin quân sĩ khiêng ngựa sắt sắp đến làng, mẹ Gióng sợ hãi chạy về bảo con:\n" +
            "\n" +
            "– Con ơi! Việc nhà vua đâu phải là chuyện chơi. Hiện quân sĩ đang kéo đến ầm ầm ngoài bãi rồi, biết làm thế nào bây giờ con?\n" +
            "\n" +
            "Nghe nói thế, Gióng vụt ngồi dậy, nói:\n" +
            "\n" +
            "– Việc đánh giặc thì mẹ đừng lo. Nhưng mẹ phải cho con ăn thật nhiều mới được!\n" +
            "\n" +
            "Mẹ vội thổi cơm cho con ăn, nhưng cứ nấu lên được nồi nào Gióng ngốn hết ngay nồi ấy. Mỗi lần ăn một nồi cơm thì Gióng lại lớn thêm một ít và đòi ăn thêm. Mẹ càng cho con ăn thì con lại càng lớn như thổi, bỗng chốc đã thành một chàng thanh niên vô cùng khỏe mạnh. Hết gạo, bà mẹ đi kêu gọi xóm làng. Mọi người nô nức đem gạo khoai, trâu, rượu, hoa quả, bánh trái mang đến đầy một sân. Nhưng đưa đến bao nhiêu thì Gióng ăn vợi hết bấy nhiêu, mà vẫn đòi ăn không nghỉ." +
            "Sau đó, Gióng lại bảo tiếp:\n" +
            "\n" +
            "– Mẹ kiếm vải cho con mặc.\n" +
            "\n" +
            "Người ta lại đua nhau mang vải lụa tới may áo quần cho Gióng mặc. Nhưng thân thể Gióng lớn vượt trội một cách kỳ lạ, áo quần vừa may xong đã thấy chật, thấy ngắn, lại phải mang vải lụa tới để chắp nối thêm. Không mấy chốc đầu Gióng đã chạm đến nóc nhà. Ai nấy chưa hết kinh ngạc thì vừa lúc quân sĩ đã hì hục khiêng được ngựa, gươm, áo giáp và nón sắt tới. Gióng bước ra khỏi nhà vươn vai một cái, người bỗng cao to sừng sững, chân dài hơn trượng, hét lên một tiếng như tiếng sấm:\n" +
            "\n" +
            "– Ta là tướng nhà Trời!\n" +
            "\n" +
            "Thế rồi Gióng mặc giáp sắt, đội nón sắt, tay cầm gươm múa quanh mấy vòng. Đoạn từ biệt mẹ và dân làng, nhảy lên lưng ngựa. Ngựa sắt bỗng chồm lên, phun thẳng ra đằng trước một luồng lửa đỏ rực. Gióng thúc chân, ngựa phi như bay, sải từng bước dài hàng chục con sào. Chỉ trong chớp mắt, ngựa đã xông đến đồn trại giặc đang đóng la liệt cả mấy khu rừng. Lưỡi gươm của Gióng vung lên loang loáng như chớp giật. Quân giặc xông ra chừng nào chết chừng ấy. Ngựa thét ra lửa thiêu cháy từng dãy đồn trại, lửa thiêu luôn cả mấy khu rừng." +
            "Nhưng tướng giặc Ân vương vẫn còn cố gào thét hô quân xáp tới, Gióng càng đánh càng khỏe, thây giặc nằm ngổn ngang. Bỗng chốc gươm gãy, Gióng không chút bối rối, thuận tay nhổ những bụi tre hai bên đường quật tới tấp vào các toán giặc đang cố gắng trụ lại theo lệnh chủ tướng. Chẳng mấy chốc quân giặc đã tẩu tán bỏ chạy khắp nơi, Ân vương bị quật chết tan xác. Bọn tàn binh giặc lạy lục xin hàng. Quân đội của Hùng Vương cũng như dân các làng chỉ còn việc xông ra trói chúng lại. Không đầy một buổi, Gióng đã trừ xong nạn cho nước nhà. Lúc bấy giờ ngựa Gióng đã tiến đến chân núi Sóc Sơn. Đến đây, Gióng bèn cởi giáp bỏ nón lại, rồi cả người lẫn ngựa bay thẳng lên trời.\n" +
            "\n" +
            "Sau khi thắng trận, để nhớ ơn người anh hùng, vua Hùng sai lập đền thờ Gióng ở làng quê, phong làm Phù Đổng thiên vương." +
            "Ngày nay chúng ta còn thấy vẫn còn những dấu vết như dãy ao tròn nối nhau kéo dài suốt từ Kim Anh, Đa Phúc cho đến Sóc Sơn, người ta bảo đó là những vết chân ngựa của Thánh Gióng. Khu rừng bị ngựa sắt phun lửa thiêu cháy nay còn mang cái tên là làng Cháy. Những cây tre mà Gióng đã nhổ quật vào giặc bị lửa đốt màu xanh ngả thành màu vàng và có những vết cháy lốm đốm, ngày nay giống ấy vẫn còn, người ta gọi là tre là ngà (hay đằng ngà)." +
            "Ý nghĩa rút ra\n" +
            "\n" +
            "Sức mạnh của Thánh Gióng chính là sức mạnh của tinh thần đoàn kết chống giặc ngoại xâm của toàn dân tộc Việt Nam. Bên cạnh đó, truyền thuyết cũng nói lên sức mạnh tiềm tàng, ẩn sâu bên trong những con người kỳ dị.','https://cotich.net/uploads/images/truyen-thuyet-thanh-giong-5.jpg',1)";

    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        //Thực hiện các câu truy vấn không trả về kết quả (Tạo bảng và insert)
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}




