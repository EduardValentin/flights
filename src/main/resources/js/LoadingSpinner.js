import React from "react";

export default ({className = "h-100 w-100", ...rest}) => (
    <div {...rest} className={`${className} d-flex align-items-center justify-content-center`}>
        <div className="spinner-border text-danger"/>
    </div>
);
