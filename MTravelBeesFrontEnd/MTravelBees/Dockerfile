#-----------------------------------first build file------------------------
# # Use the official Nginx image
# FROM nginx:alpine

# # Copy the Angular build output to Nginx's HTML directory
# COPY ./dist/mtravel-bees/browser /usr/share/nginx/html

# # Copy the Nginx configuration file
# COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf

# # Expose port 80
# EXPOSE 80

# # Start Nginx
# CMD ["nginx", "-g", "daemon off;"]
#---------------------------------------------------second build---------------------------

# Stage 1: Build the Angular application using Node.js
# FROM node:20 as build

# # Set the working directory
# WORKDIR /app

# # Copy package.json and package-lock.json to install dependencies
# COPY package*.json ./

# # Install Angular dependencies
# RUN npm install

# # Copy the rest of the application source code
# COPY . .

# # Build the Angular application for production
# RUN npm run build -- --configuration production 


# # Stage 2: Serve the application using Nginx
# FROM nginx:alpine

# # Copy the Angular build output from the Node.js stage to Nginx's HTML directory
# COPY --from=build /app/dist/mtravel-bees/browser /usr/share/nginx/html

# # Copy the Nginx configuration file
# COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf

# # Expose port 80
# EXPOSE 80

# # Start Nginx
# CMD ["nginx", "-g", "daemon off;"]

#--------------------------------------------------third build file-------------------
  # --------------------------------------------------
# Stage 1: Build the Angular application using Node.js
FROM node:20 AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json to install dependencies
COPY package*.json ./

# Install Angular dependencies (using --legacy-peer-deps for compatibility, if needed)
RUN npm install --legacy-peer-deps

# Copy the rest of the application source code
COPY . .

# Build the Angular application for production
RUN npm run build:prod

# --------------------------------------------------
# Stage 2: Serve the application using Nginx
FROM nginx:alpine

# Copy the Angular build output from the Node.js stage to Nginx's HTML directory
COPY --from=build /app/dist/mtravel-bees/browser /usr/share/nginx/html

# Copy the Nginx configuration file
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf

# Add a script to replace API_URL in index.html with the environment variable passed to the container
RUN sed -i "s|http://localhost:8090|${API_URL}|g" /usr/share/nginx/html/index.html


# Set permissions to avoid permission issues
RUN chmod -R 755 /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
# ----------------------------------------------fourth file
# # Stage 1: Build the Angular application using Node.js
# FROM node:20 AS build

# # Set the working directory
# WORKDIR /app

# # Copy package.json and package-lock.json to install dependencies
# COPY package*.json ./

# # Install Angular dependencies
# RUN npm install --legacy-peer-deps

# # Copy the rest of the application source code
# COPY . .

# # Build the Angular application for production
# RUN npm run build -- --configuration production 


# # Stage 2: Serve the application using Nginx
# FROM nginx:alpine

# # Copy the Angular build output from the Node.js stage to Nginx's HTML directory
# COPY --from=build /app/dist/mtravel-bees/browser /usr/share/nginx/html

# # Copy the Nginx configuration file
# COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf

# # Add a script to replace API_URL in index.html with the environment variable passed to the container
# RUN sed -i "s|http://localhost:8090|${API_URL}|g" /usr/share/nginx/html/index.html

# # Set permissions to avoid permission issues
# RUN chmod -R 755 /usr/share/nginx/html

# # Expose port 80
# EXPOSE 80

# # Start Nginx
# CMD ["nginx", "-g", "daemon off;"]
