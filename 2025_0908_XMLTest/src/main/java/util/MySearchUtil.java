package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.BookVo;
import vo.ProductVo;

public class MySearchUtil {

	public static List<ProductVo> search_shop(String p_name,int start,int display)
	{
		List<ProductVo> list = new ArrayList<ProductVo>();
		String clientId = "B6P5_6lUk9ZoZlmT93CT";
		String clientSecret = "8jHC8rFrhH";

		try {
			p_name = URLEncoder.encode(p_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/shop.xml?query=%s&start=%d&display=%d",
					         p_name,start,display
					);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			//발급받은 ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId); 
			//발급받은 PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret); 
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml"); 
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
											//검색한 XML데이터를 가져옴
			Document   doc = builder.build (connection.getInputStream());

			Element  root     = doc.getRootElement();
											//List<Element> 최신버전은 타입변경을 하지않아도된다.
			List<Element>   item_list = (List<Element>)root.getChild("channel").getChildren("item");

			for(Element item : item_list){
				String title = item.getChildText("title");
				String link  = item.getChildText("link");
				String image = item.getChildText("image");
				int lprice=0,hprice=0;
				try {
					lprice = Integer.parseInt(item.getChildText("lprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					hprice = Integer.parseInt(item.getChildText("hprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String mallName = item.getChildText("mallName");
				
				//상품목록을 포장
				ProductVo vo = new ProductVo();
				vo.setTitle(title);
				vo.setLink(link);
				vo.setImage(image);
				vo.setLprice(lprice);
				vo.setHprice(hprice);
				vo.setMallName(mallName);
								
				//ArrayList에 넣기
				list.add(vo);
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
	public static List<BookVo> search_book(String p_name,int start,int display)
	{
		List<BookVo> list = new ArrayList<BookVo>();
		String clientId = "B6P5_6lUk9ZoZlmT93CT";
		String clientSecret = "8jHC8rFrhH";

		try {
			p_name = URLEncoder.encode(p_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/book.xml?query=%s&start=%d&display=%d",
					         p_name,start,display
					);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			//발급받은 ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId); 
			//발급받은 PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret); 
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml"); 
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
											//검색한 XML데이터를 가져옴
			Document   doc = builder.build (connection.getInputStream());

			Element  root     = doc.getRootElement();
											//List<Element> 최신버전은 타입변경을 하지않아도된다.
			List<Element>   item_list = (List<Element>)root.getChild("channel").getChildren("item");

			for(Element item : item_list){
				String title = item.getChildText("title");
				String link  = item.getChildText("link");
				String image = item.getChildText("image");
				String author = item.getChildText("author");
				int discount=0;
				int isbn=0;
				try {
					discount=Integer.parseInt(item.getChildText("discount"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					isbn=Integer.parseInt(item.getChildText("isbn"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String publisher = item.getChildText("publisher");
				String description = item.getChildText("description");
				String pubdate=item.getChildText("pubdate");
				
				//상품목록을 포장
				BookVo vo = new BookVo();
				vo.setTitle(title);
				vo.setLink(link);
				vo.setImage(image);
				vo.setAuthor(author);
				vo.setDiscount(discount);
				vo.setPublisher(publisher);
				vo.setIsbn(isbn);
				vo.setDescription(description);
				vo.setPubdate(pubdate);
								
				//ArrayList에 넣기
				list.add(vo);
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
	
	
	
}//end MySeachUtil class
