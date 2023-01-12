# This is your repository for WebDev1 exercises

For doing the exercises you need to have git and node installed.
For node there are two options:
- direct install of the Node to your own machine
- using Vagrant on your own machine 

## Direct install
Direct install of Node.js is instructed in the Handson video which is available in Plussa first lecture week course materials. Shortly summarized:

In *Linux* you can install Node with the following commmands in your console:

`node -v`

`curl -sL https://raw.githubusercontent.com/creationix/nvm/v0.35.3/install.sh -o install_nvm.sh`

`bash install_nvm.sh`

`source ~/.profile`

`nvm install 14.9.0`

`nvm use 14.9.0`

`node -v`

In *Windows* you can follow [Microsoft's own instructions for Node installation](https://docs.microsoft.com/en-us/windows/nodejs/setup-on-windows).

## Using Vagrant to create and run a development environment on your machine
From [Vagrants Introduction](https://www.vagrantup.com/intro):
>Vagrant is a tool for building and managing virtual machine environments in a single workflow. With an easy-to-use workflow and focus on automation, Vagrant lowers development environment setup time, increases production parity, and makes the "works on my machine" excuse a relic of the past.

To start using Vagrant on your machine, first install the needed softwares

- install VirtualBox, which is used by Vagrant. [Virtualbox downloads](https://www.virtualbox.org/wiki/Downloads)
- install Vagrant. [Vagrant downloads](https://www.vagrantup.com/downloads)

After you have successfully installed both VirtualBox and Vagrant, you get to setup and access the virtual environment by using files in this repository. This repository has a _Vagrantfile_ file in its root folder, and _/vagrant_ folder, which holds _provision.sh_ file which is called from the _Vagrantfile_. You should read through these files, but you don't (and shouldn't) edit them.

In the root directory of this repository where the _Vagrantfile_ is, first run this command in your console:

`vagrant help`

This will list the available Vagrant commands. We will only be using a few of them in the following steps and this course.

Next start the configuration and setting up of the virtual environment with this command

`vagrant up`

This will take a looong time to complete, as it fetches a image of Ubuntu for the virtual machine, and runs all the installation steps defined in _provision.sh_.

After the vagrant up command has completed, you can connect to the running virtual environment with this command:

`vagrant ssh`

Now you should be in your virtual environment. All the files in repository are linked in the directory _/webdev1_ of your virtaul environment. You can access this folder with the command 
    _cd /webdev1_

Ports 3000 for Node and 27017 for MongoDB are open from the virtual environment to the same port numbers of the host system (your computers operating system). So, if you run a Node server in your virtual environment on the port 3000, you can access it from the host system with your browser using the address _localhost:3000_.

Use command `vagrant halt` to shut down the machine (when not logged in with ssh)

Use command `vagrant destroy` to delete the whole virtual machine   

If you get an error: symlink error, error -71, etc. with vagrant, use the parameter --no-bin-links.
Check https://github.com/npm/npm/issues/7308 and http://perrymitchell.net/article/npm-symlinks-through-vagrant-windows/
 


## Exercises

The wk1 exercises are stored in the git repository, and copied to your working directory when you clone the repo.
Other exercises must be pulled from the course upstream, see Plussa exercise "Setting upstream".

The procedure
- pull the instructions from upstream (not necessary in wk1); exercises are of the format `exercises/XX_desc/*.html` where XX corresponds the exercise week
- save the required files to your repository: git add FILE; git commit -m "message" FILE; git push
- give the git URL to Plussa
- Plussa grades your submission


## Support for exercises 

Available in Teams Q&A