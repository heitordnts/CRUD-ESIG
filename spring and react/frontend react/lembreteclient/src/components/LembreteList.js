import React from 'react';
import ListGroup from 'react-bootstrap/ListGroup'
import Button from 'react-bootstrap/Button'
import {Container,Row,Col} from 'react-bootstrap'
import closeIcon from '../cross.png'
import editIcon from '../edit.png'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEdit,faTrash } from "@fortawesome/free-solid-svg-icons";


class LembreteList extends React.Component{
	constructor(props){
		super(props);

		this.state={
			lembretes: [],
			foo: 1
		}

		this.API_getLembretes= this.API_getLembretes.bind(this);
		this.API_editLembrete= this.API_editLembrete.bind(this);
		this.API_removeLembrete= this.API_removeLembrete.bind(this);
		this.handleDelete= this.handleDelete.bind(this);
		this.handleEdit= this.handleEdit.bind(this);
	}

	componentDidMount(){
		this.API_getLembretes();

	}


	render(){
		return (
				<Container >
				{this.state.lembretes.map(
						l => 
						<>
					  	<Row className="my-1" key={this.state.lembretes.length} >
							<Col style={{'word-break': 'break-all'}}>
								<ListGroup>
								<ListGroup.Item>
									{l.texto}
								</ListGroup.Item>
								</ListGroup>
							</Col>
							<Col sm="auto">
								<Row>
										<Button size='sm' onClick={(a) => this.handleEdit(l)}> 
											<FontAwesomeIcon icon={faEdit}/> 
										</Button>
								</Row>
								<Row>
										<Button variant='danger' size='sm' onClick={(a) => this.handleDelete(l)}>
											<FontAwesomeIcon icon={faTrash}/> 
										</Button>
								</Row>
							</Col>
						</Row>
						</>
					)
				}	
				</Container>
			   );
	}

	handleDelete(l){
		console.log(l);
		this.API_removeLembrete(l)
		this.API_getLembretes();
	}
	handleEdit(l){
		console.log(l);
		l.texto = l.texto+'[edited]'
		this.API_editLembrete(l)
		this.API_getLembretes();

	}

	//=======API CALLS+======================
	async API_getLembretes(){
		await fetch("http://localhost:5000/api/l")
			.then(response => response.json())
			.then(data => {
					this.setState({
						lembretes: data
						}) 
					console.log(this.state.lembretes)
					}
				 );

			}
	API_editLembrete(l){
		fetch("http://localhost:5000/api/l", { 
				method: "PUT", 
				body: JSON.stringify(l), 
				headers: { 
				"Content-type": "application/json; charset=UTF-8",
				"Access-Control-Allow-Origin": "*"
				} 
			}) 
			.then(response => response.json())
	}
	API_removeLembrete(l){
		fetch("http://localhost:5000/api/l", { 
				method: "DELETE", 
				body: JSON.stringify(l), 
				headers: { 
				"Content-type": "application/json; charset=UTF-8",
				"Access-Control-Allow-Origin": "*"
				} 
			}) 
	}
}


export default LembreteList
