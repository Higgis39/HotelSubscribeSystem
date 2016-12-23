package dataService;

import java.sql.SQLException;
import java.util.ArrayList;

import po.WebPromotionPO;

public interface WebPromotionDataService {

	public boolean insert(WebPromotionPO wp);
	public boolean update(WebPromotionPO wp);
	public void delete(String name);
	public WebPromotionPO findByName(String name);
	public ArrayList<WebPromotionPO> find() throws SQLException;
	public ArrayList<WebPromotionPO> findByDiscount(double discount) throws SQLException;
}
