import React from 'react';
import './App.css';
import LembreteList from './components/LembreteList';
import Jumbotron from 'react-bootstrap/Jumbotron'
import Button from 'react-bootstrap/Button'
import Form from 'react-bootstrap/Form'

class App extends React.Component {
	constructor(props){
		super(props)
			this.state={
lembreteInput: "",
			   foo: 1
			}

		this.API_addLembrete= this.API_addLembrete.bind(this);
		this.handleAdd= this.handleAdd.bind(this);
		this.handleChange= this.handleChange.bind(this);
	}
	render(){
		return (
				<Jumbotron>
				<header className="App-header">
				LembreteStore
				</header>
				<Form>
					<Form.Group controlId="exampleForm.ControlTextarea1">
					<Form.Label>Escreva o Lembrete no campo abaixo</Form.Label>
					<Form.Control  as="input" rows="3" onChange={this.handleChange}/>
					<Button variant="primary" onClick={() => {this.handleAdd();}} >
						Submit
					</Button>
					</Form.Group>
				</Form>
				<LembreteList key={this.state.foo}/>

				</Jumbotron>
			   );
	}

	handleAdd(){
		this.setState({foo: this.state.foo+1});
		if(this.state.lembreteInput != ""){
			const l = {
texto: this.state.lembreteInput
			}
			console.log('texto eh')
				console.log(l)

				this.API_addLembrete(l)
		}
	}

	handleChange(event) {
		if(event.target.value.length > 255){
			event.target.value = event.target.value.slice(0,255);
		}
		this.setState({lembreteInput: event.target.value.slice(0,255)});
	}

	 API_addLembrete(l){
		 fetch("http://localhost:5000/api/l", { 

				method: "POST", 

				body: JSON.stringify(l), 

				// Adding headers to the request 
				headers: { 
				"Content-type": "application/json; charset=UTF-8",
				"Access-Control-Allow-Origin": "*"
				} 
			}) 
			.then(response => response.json())
	}
}

export default App;
