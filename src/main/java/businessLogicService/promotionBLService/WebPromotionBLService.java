package businessLogicService.promotionBLService;

import java.sql.SQLException;
import java.util.ArrayList;
import vo.WebPromotionVO;

/**
 * 
 * @author Thpffcj
 *
 */
public interface WebPromotionBLService {
	
	public boolean webPromotionCreate(WebPromotionVO wpv);
	
	public boolean webPromotionUpdate(WebPromotionVO wpv);
	
	public void webPromotionDelete(WebPromotionVO wpv);
	
	public ArrayList<WebPromotionVO> webPromotionFind() throws SQLException;
	
}
