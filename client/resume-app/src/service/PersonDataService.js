import axios from 'axios'

//const PERSON_API_URL = 'http://localhost:8080/api/v1/person/'
const PERSON_API_URL = 'https://localhost:44356/Person'

class PersonDataService
{
    getAllPersons()
    {
        return axios.get(PERSON_API_URL)
    }
    postPerson(person)
    {
        
        return axios.post(PERSON_API_URL, person)
    }
}

export default new PersonDataService()