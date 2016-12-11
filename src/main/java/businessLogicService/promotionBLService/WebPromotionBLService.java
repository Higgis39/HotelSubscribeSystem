package businessLogicService.promotionBLService;

import java.sql.SQLException;
import java.util.List;
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
	
	public List<WebPromotionVO> webPromotionFind() throws SQLException;
	
	public void webPromotionexecute(WebPromotionVO wpv);
}
