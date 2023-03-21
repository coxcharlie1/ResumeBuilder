
import React, { useState, useEffect } from 'react';
import Link from 'next/link';
import { DataGrid } from '@mui/x-data-grid';
import PersonDataService from '@/service/PersonDataService';


export default function ViewPeople()
{
    const [isLoaded, setIsLoaded] = useState(false);
    const [rowData, setRowData] = useState([]);

    PersonDataService.getAllPersons()
        .then((response) => {
            setIsLoaded(true);
            //console.log(response.data);
            setRowData(response.data);
            response.data.forEach(user => {

            })

        })
        , [];

    const columns = [
        { field: 'id', headerName: 'ID', width: 70 },
        { field: 'firstName', headerName: 'First name', width: 100 },
        { field: 'lastName', headerName: 'Last name', width: 100 },
        { field: 'emailAddress', headerName: 'Email', width: 180 },
        { field: 'occupation', headerName: 'Occupation', width: 220 },
        { field: 'education', headerName: 'Education', width: 180 },
        
      ];
      
      
    
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

          <p>
            <Link href="/">Back to home</Link>
          </p>
        
        </>
        
        

    );

    
    
}