package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.programs.CreateProgramsRequest;
import kodlama.io.Devs.business.requests.programs.DeleteProgramsRequest;
import kodlama.io.Devs.business.requests.programs.UpdateProgramsRequest;
import kodlama.io.Devs.business.responses.GetAllProgramsResponse;

public interface ProgramService {
	
	List<GetAllProgramsResponse> getAll();
	
	boolean add(CreateProgramsRequest createProgramsRequest) throws Exception;
	
	boolean delete(DeleteProgramsRequest deleteProgramsRequest);

	boolean update(UpdateProgramsRequest updateProgramsRequest) throws Exception;
}
