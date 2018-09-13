package com.gbedido.gbedido.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gbedido.gbedido.domain.Service;
import com.gbedido.gbedido.repository.ServiceRepository;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

	@Autowired
	ServiceRepository serviceRepository;

	@PostMapping
	public ResponseEntity<Service> saveService(@RequestBody final Service service)
	{
		return ResponseEntity.ok().body(serviceRepository.save(service));
	}
	
	@GetMapping
	public ResponseEntity<Page<Service>> findAllService(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Service> page=serviceRepository.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/search-by-libelle")
	public ResponseEntity <Page<Service>>searchService(String lib, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Service> page=serviceRepository.findByLibContaining(lib, pageable);
		return ResponseEntity.ok().body(page);
	}
	@GetMapping("/{id}")
	public Service findById(@PathVariable Long id)
	{
		return serviceRepository.findById(id).get();
	}
	
	@PostMapping("/{id}")
	public Service updateService(@PathVariable Long id, @RequestBody final Service service)
	{
		service.setId(id);
		return serviceRepository.save(service);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Long>  deleteService(@PathVariable Long id)
	{
		serviceRepository.deleteById(id);
		return ResponseEntity.ok().body(id);
	}
	
}
