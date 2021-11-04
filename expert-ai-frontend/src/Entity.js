import React from "react";

export class Entity extends React.Component {

    state = {
        type: this.props.type , 
        lemma: this.props.lemma
    }; 

    render() {
        return (
            <p>{this.state.type} - {this.state.lemma}</p>
        );
    }
} 