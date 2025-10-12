import React, { useState, useEffect } from 'react';
import {
  Box,
  Card,
  CardContent,
  Typography,
  Button,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  Chip,
  Grid,
} from '@mui/material';
import {
  Add,
  Edit,
  Delete,
  Search,
  Payment,
  AttachMoney,
  TrendingUp,
} from '@mui/icons-material';
import { DataGrid, GridColDef, GridActionsCellItem } from '@mui/x-data-grid';
import api from '../services/api';
import { toast } from 'react-toastify';

interface FeesData {
  id: number;
  studentId: number;
  studentName: string;
  amount: number;
  totalFees: number;
  balanceDue: number;
  feeType: string;
  paymentDate: string;
  academicYear: string;
  semester: string;
  status: string;
}

const Fees: React.FC = () => {
  const [fees, setFees] = useState<FeesData[]>([]);
  const [loading, setLoading] = useState(true);
  const [open, setOpen] = useState(false);
  const [editingFees, setEditingFees] = useState<FeesData | null>(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [filterType, setFilterType] = useState('');

  useEffect(() => {
    fetchFees();
  }, []);

  const fetchFees = async () => {
    try {
      // Mock data for demonstration
      const mockFees: FeesData[] = [
        {
          id: 1,
          studentId: 1,
          studentName: 'John Doe',
          amount: 5000,
          totalFees: 10000,
          balanceDue: 5000,
          feeType: 'TUITION',
          paymentDate: '2023-09-15',
          academicYear: '2023-24',
          semester: '1st',
          status: 'PARTIAL',
        },
        {
          id: 2,
          studentId: 2,
          studentName: 'Jane Smith',
          amount: 10000,
          totalFees: 10000,
          balanceDue: 0,
          feeType: 'TUITION',
          paymentDate: '2023-09-20',
          academicYear: '2023-24',
          semester: '1st',
          status: 'PAID',
        },
        {
          id: 3,
          studentId: 3,
          studentName: 'Mike Johnson',
          amount: 0,
          totalFees: 10000,
          balanceDue: 10000,
          feeType: 'TUITION',
          paymentDate: '',
          academicYear: '2023-24',
          semester: '1st',
          status: 'PENDING',
        },
      ];
      setFees(mockFees);
    } catch (error) {
      toast.error('Error fetching fees');
    } finally {
      setLoading(false);
    }
  };

  const handleAddFees = () => {
    setEditingFees(null);
    setOpen(true);
  };

  const handleEditFees = (fees: FeesData) => {
    setEditingFees(fees);
    setOpen(true);
  };

  const handleDeleteFees = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this fees record?')) {
      try {
        await api.delete(`/fees/${id}`);
        toast.success('Fees deleted successfully');
        fetchFees();
      } catch (error) {
        toast.error('Error deleting fees');
      }
    }
  };

  const handleClose = () => {
    setOpen(false);
    setEditingFees(null);
  };

  const filteredFees = fees.filter(fee =>
    fee.studentName.toLowerCase().includes(searchTerm.toLowerCase()) ||
    fee.feeType.toLowerCase().includes(searchTerm.toLowerCase()) ||
    fee.semester.toLowerCase().includes(searchTerm.toLowerCase())
  ).filter(fee =>
    filterType === '' || fee.feeType === filterType
  );

  const getStatusColor = (status: string) => {
    switch (status) {
      case 'PAID': return 'success';
      case 'PARTIAL': return 'warning';
      case 'PENDING': return 'error';
      default: return 'default';
    }
  };

  const getStatusIcon = (status: string) => {
    switch (status) {
      case 'PAID': return '✓';
      case 'PARTIAL': return '⚠';
      case 'PENDING': return '⏳';
      default: return '?';
    }
  };

  const columns: GridColDef[] = [
    {
      field: 'studentName',
      headerName: 'Student Name',
      width: 150,
    },
    {
      field: 'feeType',
      headerName: 'Fee Type',
      width: 120,
      renderCell: (params) => (
        <Chip
          label={params.value}
          color="primary"
          variant="outlined"
          size="small"
        />
      ),
    },
    {
      field: 'amount',
      headerName: 'Amount Paid',
      width: 120,
      renderCell: (params) => (
        <Typography variant="body2" fontWeight="bold" color="success.main">
          ${params.value.toLocaleString()}
        </Typography>
      ),
    },
    {
      field: 'totalFees',
      headerName: 'Total Fees',
      width: 120,
      renderCell: (params) => (
        <Typography variant="body2">
          ${params.value.toLocaleString()}
        </Typography>
      ),
    },
    {
      field: 'balanceDue',
      headerName: 'Balance Due',
      width: 120,
      renderCell: (params) => (
        <Typography 
          variant="body2" 
          fontWeight="bold"
          color={params.value > 0 ? 'error.main' : 'success.main'}
        >
          ${params.value.toLocaleString()}
        </Typography>
      ),
    },
    {
      field: 'status',
      headerName: 'Status',
      width: 120,
      renderCell: (params) => (
        <Chip
          label={`${getStatusIcon(params.value)} ${params.value}`}
          color={getStatusColor(params.value) as any}
          size="small"
        />
      ),
    },
    {
      field: 'paymentDate',
      headerName: 'Payment Date',
      width: 120,
      renderCell: (params) => (
        <Typography variant="body2">
          {params.value || 'Not Paid'}
        </Typography>
      ),
    },
    {
      field: 'semester',
      headerName: 'Semester',
      width: 100,
    },
    {
      field: 'actions',
      type: 'actions',
      headerName: 'Actions',
      width: 120,
      getActions: (params) => [
        <GridActionsCellItem
          icon={<Edit />}
          label="Edit"
          onClick={() => handleEditFees(params.row)}
        />,
        <GridActionsCellItem
          icon={<Delete />}
          label="Delete"
          onClick={() => handleDeleteFees(params.row.id)}
        />,
      ],
    },
  ];

  const totalRevenue = fees.reduce((sum, fee) => sum + fee.amount, 0);
  const totalPending = fees.reduce((sum, fee) => sum + fee.balanceDue, 0);
  const paidCount = fees.filter(fee => fee.status === 'PAID').length;
  const pendingCount = fees.filter(fee => fee.status === 'PENDING').length;

  return (
    <Box>
      <Box display="flex" justifyContent="space-between" alignItems="center" mb={3}>
        <Typography variant="h4">Fees Management</Typography>
        <Button
          variant="contained"
          startIcon={<Add />}
          onClick={handleAddFees}
        >
          Add Fees
        </Button>
      </Box>

      <Grid container spacing={3} mb={3}>
        <Grid item xs={12} sm={6} md={3}>
          <Card>
            <CardContent>
              <Box display="flex" alignItems="center">
                <AttachMoney color="success" sx={{ mr: 2, fontSize: 40 }} />
                <Box>
                  <Typography variant="h4" color="success.main">
                    ${totalRevenue.toLocaleString()}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Total Revenue
                  </Typography>
                </Box>
              </Box>
            </CardContent>
          </Card>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Card>
            <CardContent>
              <Box display="flex" alignItems="center">
                <Payment color="error" sx={{ mr: 2, fontSize: 40 }} />
                <Box>
                  <Typography variant="h4" color="error.main">
                    ${totalPending.toLocaleString()}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Pending Amount
                  </Typography>
                </Box>
              </Box>
            </CardContent>
          </Card>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Card>
            <CardContent>
              <Box display="flex" alignItems="center">
                <TrendingUp color="primary" sx={{ mr: 2, fontSize: 40 }} />
                <Box>
                  <Typography variant="h4" color="primary">
                    {paidCount}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Paid Records
                  </Typography>
                </Box>
              </Box>
            </CardContent>
          </Card>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Card>
            <CardContent>
              <Box display="flex" alignItems="center">
                <Search color="warning" sx={{ mr: 2, fontSize: 40 }} />
                <Box>
                  <Typography variant="h4" color="warning.main">
                    {pendingCount}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Pending Records
                  </Typography>
                </Box>
              </Box>
            </CardContent>
          </Card>
        </Grid>
      </Grid>

      <Card>
        <CardContent>
          <Box display="flex" alignItems="center" gap={2} mb={2}>
            <TextField
              placeholder="Search fees..."
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              InputProps={{
                startAdornment: <Search />,
              }}
              sx={{ minWidth: 300 }}
            />
            <FormControl sx={{ minWidth: 150 }}>
              <InputLabel>Fee Type</InputLabel>
              <Select
                value={filterType}
                label="Fee Type"
                onChange={(e) => setFilterType(e.target.value)}
              >
                <MenuItem value="">All Types</MenuItem>
                <MenuItem value="TUITION">Tuition</MenuItem>
                <MenuItem value="LIBRARY">Library</MenuItem>
                <MenuItem value="LABORATORY">Laboratory</MenuItem>
                <MenuItem value="EXAMINATION">Examination</MenuItem>
                <MenuItem value="TRANSPORT">Transport</MenuItem>
                <MenuItem value="HOSTEL">Hostel</MenuItem>
              </Select>
            </FormControl>
          </Box>

          <DataGrid
            rows={filteredFees}
            columns={columns}
            loading={loading}
            pageSizeOptions={[5, 10, 25]}
            initialState={{
              pagination: {
                paginationModel: { pageSize: 10 },
              },
            }}
            disableRowSelectionOnClick
            sx={{ height: 400 }}
          />
        </CardContent>
      </Card>

      <Dialog open={open} onClose={handleClose} maxWidth="md" fullWidth>
        <DialogTitle>
          {editingFees ? 'Edit Fees' : 'Add New Fees'}
        </DialogTitle>
        <DialogContent>
          <Box sx={{ pt: 2 }}>
            <FormControl fullWidth margin="normal">
              <InputLabel>Student</InputLabel>
              <Select label="Student">
                <MenuItem value="1">John Doe</MenuItem>
                <MenuItem value="2">Jane Smith</MenuItem>
                <MenuItem value="3">Mike Johnson</MenuItem>
              </Select>
            </FormControl>
            <FormControl fullWidth margin="normal">
              <InputLabel>Fee Type</InputLabel>
              <Select label="Fee Type">
                <MenuItem value="TUITION">Tuition</MenuItem>
                <MenuItem value="LIBRARY">Library</MenuItem>
                <MenuItem value="LABORATORY">Laboratory</MenuItem>
                <MenuItem value="EXAMINATION">Examination</MenuItem>
                <MenuItem value="TRANSPORT">Transport</MenuItem>
                <MenuItem value="HOSTEL">Hostel</MenuItem>
              </Select>
            </FormControl>
            <Box display="flex" gap={2}>
              <TextField
                fullWidth
                label="Amount Paid"
                type="number"
                margin="normal"
                required
              />
              <TextField
                fullWidth
                label="Total Fees"
                type="number"
                margin="normal"
                required
              />
            </Box>
            <TextField
              fullWidth
              label="Payment Date"
              type="date"
              margin="normal"
              InputLabelProps={{ shrink: true }}
            />
            <Box display="flex" gap={2}>
              <TextField
                fullWidth
                label="Academic Year"
                margin="normal"
                required
              />
              <TextField
                fullWidth
                label="Semester"
                margin="normal"
                required
              />
            </Box>
            <TextField
              fullWidth
              label="Description"
              margin="normal"
              multiline
              rows={3}
            />
          </Box>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button variant="contained">
            {editingFees ? 'Update' : 'Create'}
          </Button>
        </DialogActions>
      </Dialog>
    </Box>
  );
};

export default Fees;
