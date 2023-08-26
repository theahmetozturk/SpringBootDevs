package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllSubTechnologyResponse;

public interface SubTechnologyService {

	List<GetAllSubTechnologyResponse> getAll();
	
	boolean add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;
	
	boolean delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest);
	
	boolean update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception;


	
}
