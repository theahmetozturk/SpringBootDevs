package kodlama.io.Devs.wepApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllSubTechnologyResponse;

@RestController
@RequestMapping("/api/subTechnology")
public class SubTechnologyController {
	private SubTechnologyService subTechnologyService;
	
	public SubTechnologyController(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}

	@GetMapping("/getAll")
	public List<GetAllSubTechnologyResponse> getAll(){
		return subTechnologyService.getAll();
		
	}
	
	@PostMapping("/add")
	public boolean add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		return subTechnologyService.add(createSubTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public boolean delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		return this.subTechnologyService.delete(deleteSubTechnologyRequest);
	}
	
	public boolean update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		return this.subTechnologyService.update(updateSubTechnologyRequest);
	}	
	
	
}
