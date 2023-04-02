package com.example.appdoctruyen62TH4byNhom6.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appdoctruyen62TH4byNhom6.model.TaiKhoan;
import com.example.appdoctruyen62TH4byNhom6.model.Truyen;

public class databasedoctruyen extends SQLiteOpenHelper {
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
    private String SQLQuery11 = "INSERT INTO TaiKhoan VAlUES (null,'su','su','su@gmail.com',1)";

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
    private String SQLQuery5 = "INSERT INTO truyen VALUES (null,'Củ cải trắng','Mùa đông đã đến rồi trời lạnh buốt, Thỏ con không có gì để ăn cả. Thỏ con mặc áo vào rồi ra ngoài kiếm thức ăn. Nó đi mãi đi mãi cuối cùng cũng tìm được hai củ cải trắng. Thỏ con reo lên:\n" +
            "\n" +
            "– Ôi, ở đây có hai củ cải trắng liền, mình thật là may mắn!\n" +
            "\n" +
            "Thỏ con đói bụng, muốn ăn lắm rồi. Nhưng Thỏ lại nghĩ:\n" +
            "\n" +
            "– Ừm… trời lạnh thế này, chắc Dê con cũng không có cái gì để ăn đâu. Mình phải mang cho Dê con một củ mới được.\n" +
            "\n" +
            "Thế là Thỏ con đi sang nhà bạn Dê nhưng Dê con không có nhà nên Thỏ đặt củ cải lên bàn rồi đi về.\n" +
            "\n" +
            "Tình cờ, Dê con đi chơi cũng tìm được một củ cải trắng nhưng nó chỉ ăn trước một nửa.\n" +
            "\n" +
            "Về đến nhà, lại thấy có một củ cải trắng ở trên bàn Dê thèm ăn lắm, nhưng lại nghĩ:\n" +
            "\n" +
            "– Ôi trời lạnh thế này chắc Hươu con không có cái gì để ăn rồi, mình phải mang cho Hươu con mới được.\n" +
            "\n" +
            "Dê con đến nhà Hươu nhưng Hươu lại đi vắng, Dê con bèn đặt củ cải ở trên bàn rồi về.\n" +
            "\n" +
            "Khi Hươu về nhà, thấy củ cải ở trên bàn, Hươu ngạc nhiên lắm.\n" +
            "\n" +
            "– Ồ, củ cải trắng ở đâu mà ngon vậy nhỉ. Xuỵt… thích quá. Nhưng chắc trời lạnh thế này, Thỏ con cũng không có gì ăn đâu. Mình phải mang sang cho Thỏ mới được.\n" +
            "\n" +
            "Khi Hươu đến thì Thỏ con đang ngủ rất say. Khi tỉnh dậy Thỏ lại thấy trên bàn mình xuất hiện một củ cải trắng.Thỏ vui lắm nó chạy đi gọi các bạn:\n" +
            "\n" +
            "– Bạn Hươu ơi, bạn Dê ơi hãy đến nhà tôi, chúng ta cùng ăn củ cải trắng thơm ngon này.\n" +
            "\n" +
            "Thế là cuối cùng, củ cải trắng ấy được chia sẻ cho cả ba người bạn tốt bụng của chúng ta. Các bạn thấy đấy tấm lòng thơm thảo, sẵn sàng sẻ chia của các bạn ấy thật là đáng học tập phải không nào?\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Khi cho đi bạn sẽ nhận lại được nhiều hơn những thứ mình có.','https://toplist.vn/images/800px/cu-cai-trang-230181.jpg',1)";
    private String SQLQuery6 = "INSERT INTO truyen VALUES (null,'Dê đen và dê trắng','Dê đen và Dê trắng cùng sống trong một khu rừng. Hàng ngày, cả hai thường đến uống nước và tìm cái ăn ở trong khu rừng quen thuộc.\n" +
            "\n" +
            "Một hôm, Dê trắng đi tìm cái ăn và uống nước suối như mọi khi. Dê đang mải mê ngặm cỏ, bất chợt một con Sói ở đâu nhảy xổ ra. Sói quát hỏi:\n" +
            "\n" +
            "- Dê kia! Mi đi đâu?\n" +
            "\n" +
            "Dê trắng sợ rúm cả người, lắp bắp:\n" +
            "\n" +
            "– Dạ, dạ, tôi đi tìm… tìm cỏ non và…và uống nước suối ạ!\n" +
            "\n" +
            "Sói lại quát hỏi:\n" +
            "\n" +
            "– Mi có gì ở chân?\n" +
            "\n" +
            "– Dạ, dạ, chân của tôi có móng ạ…ạ!\n" +
            "\n" +
            "– Trên đầu mi có gì?\n" +
            "\n" +
            "– Dạ, dạ, trên đầu tôi có đôi sừng mới nhú…\n" +
            "\n" +
            "Sói càng quát to hơn:\n" +
            "\n" +
            "– Trái tim mi thế nào?\n" +
            "\n" +
            "– Ôi, ôi, trái…trái tim tôi đang run sợ…sợ…\n" +
            "\n" +
            "– Hahaha…\n" +
            "\n" +
            "Sói cười vang rồi ăn thịt chú Dê trắng tội nghiệp\n" +
            "\n" +
            "Dê đen cũng đi tới khu rừng để ăn cỏ non và uống nước suối. Đang tha thẩn ngặm cỏ, chợt Sói xuất hiện, nó quát hỏi:\n" +
            "\n" +
            "– Dê kia, mi đi đâu?\n" +
            "\n" +
            "Dê đen nhìn con Sói từ đầu tới chân rồi ngước cổ trả lời:\n" +
            "\n" +
            "– Ta đi tìm kẻ nào thích gây sự đây!\n" +
            "\n" +
            "Sói bị bất ngờ, nó hỏi tiếp:\n" +
            "\n" +
            "– Thế dưới chân mi có gì?\n" +
            "\n" +
            "– Chân thép của ta có móng bằng đồng.\n" +
            "\n" +
            "– Thế…thế…trên đầu mi có gì?\n" +
            "\n" +
            "– Trên đầu của ta có đôi sừng bằng kim cương!\n" +
            "\n" +
            "Sói sợ lắm rồi, nhưng vẫn cố hỏi:\n" +
            "\n" +
            "– Mi…mi…trái tim mi thế nào?\n" +
            "\n" +
            "Dê đen dõng dạc trả lời:\n" +
            "\n" +
            "– Trái tim thép của ta bảo ta rằng: hãy cắm đôi sừng kim cương vào đầu Sói. Nào, Sói hãy lại đây.\n" +
            "\n" +
            "Ôi trời, sợ quá, con Sói ba chân bốn cẳng chạy biến vào rừng, từ đó không ai trông thấy nó lởn vởn ở khu rừng đó nữa.\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Qua câu chuyện ngụ ngôn trên, bạn có thể truyền tải nhiều thông điệp khác nhau cho bé hiểu. Chẳng hạn như biết cách ứng xử trước các tình huống khó, nguy hiểm, lạc quan và bản lĩnh để xử lý vấn đề.','https://toplist.vn/images/800px/de-den-va-de-trang-230182.jpg',1)";
    private String SQLQuery7 = "INSERT INTO truyen VALUES (null,'Chú bé chăn cừu','Một chú bé chăn cừu cho chủ thả cừu gần một khu rừng rậm cách làng không xa lắm. Chăn cừu được ít lâu, chú cảm thấy công việc chăn cừu thực là nhàm chán. Tất cả mọi việc chú có thể làm để giải khuây là nói chuyện với con chó hoặc thổi chiếc sáo chăn cừu của mình.\n" +
            "\n" +
            "Một hôm, trong lúc đang ngắm nhìn đàn cừu và cánh rừng yên tĩnh chú bé chợt nhớ tới lời chủ của chú từng dặn rằng khi sói tấn công cừu thì phải kêu cứu để dân làng nghe thấy và đánh đuổi nó đi.\n" +
            "\n" +
            "Thế là chú nghĩ ra một trò chơi cho đỡ buồn. Mặc dù chẳng thấy con sói nào, chú cứ chạy về làng và la to:\n" +
            "\n" +
            "– Sói ! Sói !\n" +
            "\n" +
            "Đúng như chú nghĩ, dân làng nghe thấy tiếng kêu bỏ cả việc làm và tức tốc chạy ra cánh đồng. Nhưng khi đến nơi, họ chẳng thấy sói đâu, chỉ thấy chú bé ôm bụng cười ngặt nghẽo vì đã lừa được họ.\n" +
            "\n" +
            "Ít ngày sau chú bé chăn cừu lần nữa lại la lên:\n" +
            "\n" +
            "– “Sói ! Sói !”.\n" +
            "\n" +
            "Và một lần nữa dân làng lại chạy ra giúp chú. Nhưng họ lại chẳng thấy con sói nào, chỉ thấy chú bé chăn cừu nghịch ngợm ôm bụng cười khoái chí.\n" +
            "\n" +
            "Thế rồi vào một buổi chiều nọ, khi mặt trời lặn xuống sau cánh rừng và bóng tối bắt đầu phủ đầy lên cánh đồng, một con sói thực sự xuất hiện. Nó nấp sau bụi cây rình bắt những con cừu béo non. Bỗng sói phóng vút ra chộp lấy một chú cừu tội nghiệp. Thấy sói cả đàn cừu sợ hãi chạy toán loạn, chú bé chăn cừu cũng hoảng loạn vô cùng.\n" +
            "\n" +
            "Quá hoảng sợ, chú bé chăn cừu vội chạy về làng và la to:\n" +
            "\n" +
            "– “Sói ! Sói !”.\n" +
            "\n" +
            "Nhưng mặc dù dân làng có nghe tiếng chú kêu, không một ai chạy ra để giúp chú như những lần trước cả. Vì mọi người nghĩ chú lại bày trò nói dối như trước.\n" +
            "\n" +
            "Thế là sói thỏa sức bắt mồi, giết chết rất nhiều cừu của chú bé. Sau khi đã chén no nê, nó biến mất vào rừng rậm. Chú bé buồn bã ngồi giữa đồng cỏ, lòng đầy hối hận về hành động nói dối của mình và hậu quả của trò đùa dại dột gây ra.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Nói dối là một tật xấu. Người hay nói dối ngay cả khi nói thật cũng không ai tin.','https://toplist.vn/images/800px/chu-be-chan-cuu-230183.jpg',1)";
    private String SQLQuery8 = "INSERT INTO truyen VALUES (null,'Cậu bé chăn cừu và cây đa cổ thụ','Ngày xửa ngày xưa, xưa lắm rồi khi mà muôn thú, cây cỏ, con người còn trò chuyện được với nhau. Trên đồng cỏ rậm ven khu làng có một loài cây gọi là cây đa. Đó là một thứ cây to, khỏe, lá của nó rậm rạp đến nỗi không một tia nắng nào có thể lọt qua được. Vào những ngày trời nắng nóng người ta thường nghỉ chân một lát và trò chuyện hàn huyên cùng cây dưới bóng cây mát rượi. Mọi người ai cũng biết rằng cây đa rất thông thái vì cây đã có tuổi, đã từng trải.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://toplist.vn/images/800px/cau-be-chan-cuu-va-cay-da-co-thu-230184.jpg',1)";

    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        //Truy vấn ko có trả về kq , Tạo bảng và insert
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery11);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void AddTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();

        //không thể lưu trực tiếp xuống insert nên thông qua contentvalues
        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taiKhoan.getmTenTaiKhoan());
        values.put(MAT_KHAU,taiKhoan.getmMatKhau());
        values.put(EMAIL,taiKhoan.getmEmail());
        values.put(PHAN_QUYEN,taiKhoan.getmPhanQuyen());

        db.insert(TABLE_TAIKHOAN,null,values);
        //đóng lại db cho an toàn
        db.close();
        //Log.e("Add Tai Khoan ","thành công");
    }


    //Lấy tất cả tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_TAIKHOAN , null );
        return res;
    }



    //Thêm truyện
    public void AddTruyen(Truyen truyen){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEN_TRUYEN,truyen.getTenTruyen());
        values.put(NOI_DUNG,truyen.getNoiDung());
        values.put(IMAGE,truyen.getAnh());
        values.put(ID_TAI_KHOAN,truyen.getID_TK());

        db.insert(TABLE_TRUYEN,null,values);
        db.close();
        Log.e("Add Truyện : ","Thành công");
    }


    //Lấy tin mới nhất
    public Cursor getData1(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 3" , null );
        return res;
    }


    //Lấy tất cả truyện
    public Cursor getData2(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN,null);
        return res;
    }


    //Xóa truyện với id = i
    public int Delete(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        int res = db.delete("truyen",ID_TRUYEN+" = "+i,null);
        return res;

    }
}



