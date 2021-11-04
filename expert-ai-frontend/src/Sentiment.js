import React from "react";

export class Sentiment extends React.Component{
   
    state = {
        overall : this.props.overall, 
        positivity: this.props.positivity,
        negativity: this.props.negativity
    }; 

    render(){
        return <p>{this.state.overall} - {this.state.positivity} - {this.state.negativity}</p>
    }
}