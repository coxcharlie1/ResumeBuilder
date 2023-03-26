
import React, { useState, useEffect } from 'react';
import Link from 'next/link';
import { DataGrid } from '@mui/x-data-grid';
import PersonDataService from '@/service/PersonDataService';
import Button from '@mui/material/Button';

import InputLabel from '@mui/material/InputLabel';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
//import addPerson from './add-person';


export default function ViewPeople()
{
    const [isLoaded, setIsLoaded] = useState(false);
    const [rowData, setRowData] = useState([]);
    const [newPersonData, setNewPersonData] = useState({
      firstName: "",
      lastName: "",
      emailAddress: "",
      occupation: "",
      education: ""

    });
    
    useEffect(() => {
      PersonDataService.getAllPersons()
      .then((response) => {
          setIsLoaded(true);
          //console.log(response.data);
          setRowData(response.data);
          response.data.forEach(user => {

          })

      })

    }, [])
   

    const columns = [
        { field: 'id', headerName: 'ID', width: 70 },
        { field: 'firstName', headerName: 'First name', width: 100 },
        { field: 'lastName', headerName: 'Last name', width: 100 },
        { field: 'emailAddress', headerName: 'Email', width: 180 },
        { field: 'occupation', headerName: 'Occupation', width: 220 },
        { field: 'education', headerName: 'Education', width: 180 },
        
      ];
    //this.handleSubmit = this.handleSubmit.bind(this);
    
    const handleChange = (e) => {
      
      setNewPersonData({
        ...newPersonData,
        [e.target.name]: e.target.value
      });
    };
    const handleSubmit = (e) => {
      e.preventDefault();
      console.log(newPersonData)
      PersonDataService.postPerson(newPersonData)
      .then((response) => {
        //console.log(response.data);
        setRowData([...rowData,response.data]);
        

    })
      
    }
          
    
    return (
        <>
          <h1>People</h1>
          <div style={{ height: 400, width: '100%' }}>
            <DataGrid
            id="id"
            rows={rowData}
            columns={columns}
            pageSize={5}
            rowsPerPageOptions={[5]}
            checkboxSelection
            //onRowClick={handleEvent} 

            />
          </div>
          <form onSubmit={handleSubmit} >
          <Box className="personForm"
            sx={{
            display: 'flex',
            alignItems: 'center',
            '& > :not(style)': { m: 1 },
            }}
          >
            
          
            <TextField
              helperText="First Name"
              id="demo-helper-text-aligned"
              label="John"
              name="firstName"
              onChange={handleChange}

            />
            <TextField
              helperText="Last Name"
              id="demo-helper-text-aligned"
              label="Smith"
              name="lastName"
              onChange={handleChange}
            />
            <TextField
              helperText="Email"
              id="demo-helper-text-aligned"
              label="john.smith@email.com"
              name="emailAddress"
              onChange={handleChange}
              
            />
            <TextField
              helperText="Occupation"
              id="demo-helper-text-aligned"
              label="occupation"
              name="occupation"
              onChange={handleChange}
            />

            <TextField
              helperText="Education"
              id="demo-helper-text-aligned"
              label="degree"
              name="education"
              onChange={handleChange}
            />
           
        
        </Box>
    
      <Button variant="contained" type="submit">Add</Button>
      </form>
          <p>
            <Link href="/">Back to home</Link>
          </p>
        
        </>
        
        

    );

    
    
}