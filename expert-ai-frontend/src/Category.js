import React from "react";

export class Category extends React.Component{

state = {
  label: this.props.label , 
  score: this.props.score , 
  frequency: this.props.frequency  
};

render(){
   return <p>{this.state.label} - {this.state.score} - {this.state.frequency} </p>
}

}