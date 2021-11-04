import React from "react";

export class Topic extends React.Component{

    state = {
        label: this.props.label , 
        score: this.props.score 
    };

    render(){
        return <p>{this.state.label} - {this.state.score}</p>         
    }

}