package kodlama.io.Devs.wepApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgramService;
import kodlama.io.Devs.business.requests.programs.CreateProgramsRequest;
import kodlama.io.Devs.business.requests.programs.DeleteProgramsRequest;
import kodlama.io.Devs.business.requests.programs.UpdateProgramsRequest;
import kodlama.io.Devs.business.responses.GetAllProgramsResponse;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {
	private ProgramService programService;

	public ProgramController(ProgramService programService) {

		this.programService = programService;
	}

	@GetMapping("/getAll")
	public List<GetAllProgramsResponse> getAll() {

		return programService.getAll();
	}

	@PostMapping("/add")
	public boolean add(CreateProgramsRequest createProgramsRequest) throws Exception {
		return programService.add(createProgramsRequest);

	}
	@DeleteMapping("/delete")
	public boolean delete(DeleteProgramsRequest deleteProgramsRequest) {
		return this.programService.delete(deleteProgramsRequest);
	}

	@PutMapping("/update")
	public boolean update(UpdateProgramsRequest updateProgramsRequest) throws Exception {
		return this.programService.update(updateProgramsRequest);
	}

}
