using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;
using ResumeBuilder.Services;


namespace ResumeBuilder.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class PersonController : ControllerBase
    {
        private PersonService service;
       
        public PersonController(PersonService personService) 
        {
            this.service = personService;   
        }

        [HttpGet]
        //[EnableCors("AllowSpecificOrigin")]
        public IActionResult GetAll()
        {
            var users = service.GetAll();
            return Ok(users);
        }
    }
}
