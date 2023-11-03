package springSearch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.mysql.cj.util.StringUtils;

import springSearch.model.UserFiles;
import springSearch.service.FileService;

@Controller
	public class searchController {
	
		@Autowired
		private FileService fileService;
		
		
		@RequestMapping("/")
		public String home() {
			
			/*
			 * String str = null; System.out.println(str.length());
			 */
			
			return "search";
			
		}
		
		
		@RequestMapping("/searchBar")
		public RedirectView view(@RequestParam("searchUserData") String searched ) {
			
			
			
			String url = "https://www.google.com/search?q="+searched;
			
			
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(url);
			
			if(searched.isEmpty()) {
				redirectView.setUrl("home");
				}
				
			
			return redirectView;
			
			
			
		}
		
		
		/* Handler for Exception Handling using ExceptionHandler and Controller Advice*/
		
		/*
		 * @ExceptionHandler({NullPointerException.class})
		 * 
		 * @RequestMapping("/null") public String nullException() { return "null"; }
		 */
		
		
		
		/* Handler for FileUpload View(UI) Page*/
		
		@RequestMapping(path="/fileUploadprocess" , method=RequestMethod.POST)
		public String fileUpload() {
			
			return "fileUpload";
		}
		
		
		
		/* Handler for Interceptor Page*/
		
		@RequestMapping(path="/InterceptorPage" , method=RequestMethod.POST)
		public String InterceptorConcept() {
			
			return "interceptor";
		}
		
		
		
		
		
		
		
		
		/* Handler for FileUpload in Database */
		
		
	//	@RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
	//	@PostMapping(value = "/uploadFile", consumes = MediaType.APPLICATION_PDF_VALUE)
		@RequestMapping(path = "/uploadFile", produces={"application/pdf"})
	    public String browseFile(@RequestParam("fileData") MultipartFile userDropFile,Model model) {
	
			
			/*if(StringUtils.endsWithIgnoreCase(userFiles.getFilename(), "pdf") || StringUtils.endsWithIgnoreCase(userFiles.getFilename(), "docx"))
			{
			*/
			
			
			 if (!userDropFile.isEmpty()) {
		            try {
		            	
		            	if(userDropFile.getContentType().equals("application/pdf")) 
		            	{
		            	
		                fileService.uploadFile(userDropFile);
		                model.addAttribute("message", "File uploaded");
		            	}
		            	else {
		            		
		            		return "fileUpload";
		            	}
		            } catch (IOException e) {
		                model.addAttribute("message", "File failed: " + e.getMessage());
		            }
		        }
			//}
			 else {
		            model.addAttribute("message", "Please select a file to upload");
		        }
			return "fileUploadedSucc";
	   }
		
		
		
		
		
	}
