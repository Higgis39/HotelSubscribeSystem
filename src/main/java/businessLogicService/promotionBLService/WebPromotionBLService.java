package businessLogicService.promotionBLService;

import java.sql.SQLException;
import java.util.List;

import po.WebPromotionPO;
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
	
	public List<WebPromotionPO> webPromotionFind(WebPromotionVO wpv) throws SQLException;
	
	public void webPromotionexecute(WebPromotionVO wpv);
}
