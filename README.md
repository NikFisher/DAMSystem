# DAMSystem
A digital asset management system

This is a personal project that I've been working on.  
It's meant for storing, viewing and labeling various kinds of marketing material.
An asset/digital asset is a piece of marketing material that can be an image, a document or a video.

An asset has a file type, a material type as well as various other attributes.
The file type is specified by the user and indicates if the asset is an image, document or video. 

An asset's material type specifies what kind of material it is.  For example a product image is an image of the product
while a packaging image is an image of the product's packaging.
An asset can be tied one or several products (or no products at all).

The process of specifying an the asset's file type, material type, product(s), description, etc is known as tagging.

A system like this would be connected to an external system such as a company website which is accessed by the employees.
The marketing team would use the DAMsystem to upload and tag the material they create so that it can be uploaded to the company
website to be used by other employees for various purposes.  

So far, the system can only tag images and cannot upload new assets.  The system has not been connected to a database so the 
changes made aren't saved once the program is closed.

My next steps are to enable the uploading of new files as well as connect the system to a database.  
